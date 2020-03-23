package model.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;

import Exception.SQLResultEmptyException;
import presenter.operate.Reception;
import presenter.operate.Reserve;

public class NormalUser implements Reception, Reserve{
	
	private Connection con = null;
	private Statement statement = null;
	
	public NormalUser(Connection con) throws SQLException { 		
		this.con = con;
	}
	
	public void initDB() throws SQLException {
		con.setAutoCommit(false);
		this.statement = con.createStatement();
	}
	
	/**
	 * 获取所有房间信息
	 */
	@Override
	public String[][] getRoomStatus() throws Exception{
		String sql = "select * from `room`;";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		rs.last();
		int row = rs.getRow();
		String[][] room = new String[row][5];
		int i = 0;
		rs.first();
		while(rs.next()) {
		    room[i][0] = Integer.toString(rs.getInt("room_num"));
		    room[i][1] = rs.getString("type");
		    room[i][2] = Float.toString(rs.getFloat("price"));
		    room[i][3] = Float.toString(rs.getFloat("guarantee_deposit"));
		    room[i][4] = rs.getString("status");
		    i++;
		}
		return room;
	}
	
	/**
	 * 获取所查房间的押金
	 * @param room_num
	 * @return float 返回所查房间的押金
	 * @throws Exception
	 */
	float getGuarantee_deposit(int room_num) throws SQLException{
		String sql = "SELECT `guarantee_deposit` FROM `room` WHERE room_num = " + room_num + ";";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		return rs.getFloat("guarantee_deposit");
	}
	
	/**
	 * 获取所查房间的价格
	 * @param room_num
	 * @return float 返回所查房间的价格
	 * @throws Exception
	 */
	float getPrice(int room_num) throws SQLException{
		String sql = "SELECT `price` FROM `room` WHERE `room_num` = " + room_num + ";";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		return rs.getFloat("price");
	}
	
	/**
	 * 获取一个已住但未结算的房间的入住时间
	 * @param room_num
	 * @return Timestamp 放回所查的入住时间
	 * @throws SQLException
	 */
	public Timestamp getCheck_in_date(int room_num) throws SQLException{
		String sql = "SELECT `check-in_date` FROM `manager` WHERE `room_num` = %d AND `check-out_date` is null;";
		sql = String.format(sql, room_num);
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		
		return rs.getTimestamp("check-in_date");
	}

	/**
	 * 获取指定房间的状态
	 * @param room_num
	 * @return String 返回所查询房间的状态
	 * @throws SQLException
	 */
	public String getRoomStatus(int room_num) throws SQLException{
		String sql = "SELECT * FROM `room` WHERE `room_num` = " + room_num + ";";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		
		return rs.getString("status");
	}

	/**
	 * 获取已预定房间的预计退房时间
	 * @param room_num
	 * @param id_type
	 * @param id_num
	 * @return 返回一个Timestamp类型的预计退房时间
	 * @throws SQLResultEmptyException
	 * @throws SQLException
	 */
	Timestamp getReservation(int room_num, String id_type, String id_num) throws SQLResultEmptyException, SQLException{
		String sql = "SELECT * FROM `reservation` WHERE `room_num` = %d AND `id_type` = '%s' AND `id_num` = '%s' AND `status` = '已定'";
		sql = String.format(sql, room_num, id_type, id_num);
		
		ResultSet rs = statement.executeQuery(sql);
		if (false == rs.next()) {
			throw new SQLResultEmptyException();
		}
		
		return rs.getTimestamp("expected_check-out_date");
	}
	
	/**
	 * 添加房间预定信息
	 * @param room_num
	 * @param id_type
	 * @param id_num
	 * @param employee_id
	 * @param status
	 * @param check_in_date
	 * @param expected_check_out_date
	 * @return 返回一个状态码，-1表示操作失败
	 */
	int addReservation(int room_num, String id_type, String id_num, int employee_id,
			String status, Timestamp check_in_date, Timestamp expected_check_out_date) {
		int alter_status = 0;
		String sql = "INSERT INTO `reservation`"
				+ "(`employee_id`,`room_num`,`id_type`,`id_num`,`check-in_date`,`expected_check-out_date`,`status`)"
				+ " VALUES(%d, %d, '%s', '%s', '%s', '%s', '%s');";
		sql = String.format(sql, employee_id, room_num, id_type, id_num, check_in_date, expected_check_out_date, status);
		
		try {
		    alter_status = statement.executeUpdate(sql);
		} catch (SQLException e){
			alter_status = -1;
		}
		return alter_status;
	}

	/**
	 * 添加入住信息
	 * @param room_num
	 * @param id_type
	 * @param id_num
	 * @param check_in_date
	 * @param expected_check_out_date
	 * @param check_out_date
	 * @param sum_owing
	 * @return 返回一个状态码，-1表示操作失败
	 */
	int addManager(int room_num, String id_type, String id_num, Timestamp check_in_date,
			Timestamp expected_check_out_date, Timestamp check_out_date, float sum_owing) {
		int add_status = 0;
		String sql = "INSERT INTO `manager` VALUES(1, %d, '%s', '%s', '%s', '%s', '%s', %.1f);";
		 sql = String.format(sql, room_num, id_type, id_num, check_in_date, expected_check_out_date, check_out_date, sum_owing);
		 try {
			 add_status = statement.executeUpdate(sql);
		 } catch (SQLException e) {
	         add_status = -1;
		 }
		 
		 return add_status;
	}
	
	/**
	 * 更新客人信息
	 * @param id_type 客人的证件类型
	 * @param id_num
	 * @param name
	 * @param sex
	 * @param phone
	 * @return int 返回一个状态码，-1表示操作失败
	 */
	int addClient(String id_type, String id_num, String name, String sex, String phone){
		int add_status = 0;
		String sql = "INSERT INTO `client`(`id_type`, `id_num`, `name`, `sex`, `phone`) VALUES('%s', '%s', '%s', '%s', '%s');";
		sql = String.format(sql, id_type, id_num, name, sex, phone);
		try {
			add_status = statement.executeUpdate(sql);
		}catch(SQLIntegrityConstraintViolationException e) {
			add_status = 0;
		}catch(SQLException e) {
			add_status = -1;
		}
		return add_status;
	}
	
	/**
	 * 更新房间状态信息
	 * @param room_num
	 * @param status 房间状态（1.已住 2.已定 3.未定）
	 * @return int 返回一个状态码，-1代表操作失败
	 */
	int alterRoomStatus (int room_num, String status) throws SQLException{
		int alter_status = 0;
		String sql = "SELECT * FROM room WHERE room_num = " + room_num;

		try {
			ResultSet rs = statement.executeQuery(sql);
			rs.next();
			String room_status = rs.getString("status");
			if ((room_status.equals("未定") || room_status.equals("已定") && status.equals("已住"))
					|| (room_status.equals("未定") && status.equals("已定"))
					|| (room_status.equals("已定") || room_status.equals("已住") && status.equals("未定"))) {
				sql = "UPDATE `room` SET `status` = '%s' WHERE `room_num` = %d;";
				sql = String.format(sql, status, room_num);
				alter_status = statement.executeUpdate(sql);
				}
		} catch (SQLException e) {
			alter_status = -1;
			System.out.println("更新房间状态失败" + 2);
		}

		return alter_status;
	}
	
	/**
	 * 更新房间预定信息：
	 * @param room_num int
	 * @param id_type String
	 * @param id_num String
	 * @param status
	 * @return int 返回一个状态码，-1表示操作失败
	 */
	int alterReservation(int room_num, String id_type, String id_num, int employee_id, String status) {
		int alter_status = 0;
		String sql = "UPDATE `reservation` SET `status` = '%s' WHERE `room_num` = %d AND `id_type` = '%s' AND `id_num` = '%s' AND `status` = '%s';";
			sql = String.format(sql, status, room_num, id_type, id_num, "已定");
		try {
		    alter_status = statement.executeUpdate(sql);
		} catch (SQLException e){
			alter_status = -1;
		}
	
		return alter_status;
	}
	
	/**
	 * 更新入住信息
	 * @param room_num
	 * @param check_in_date
	 * @param check_out_date
	 * @param sum_owing
	 * @return
	 */
	int alterManager(int room_num, Timestamp check_in_date, Timestamp check_out_date , float sum_owing) {
		int alter_status = 0;
		String sql = "UPDATE `manager` SET `check-out_date` = '%s', `sum_owing` = %.1f WHERE `room_num` = %d AND `check-in_date` = '%s';";
		sql = String.format(sql, check_out_date , sum_owing, room_num, check_in_date);
		
		try {
			// 更新管理表
			alter_status = statement.executeUpdate(sql);
		} catch (SQLException e) {
			alter_status = -1;
		}
		return alter_status;
	}
	
	/**
	 * 开房
	 * @throws SQLException 
	 */
	@Override
	public void checkInRoom() throws SQLException{
		int room_num = 403;
		
		try {
			// 更新房间状态
			int alter_status = alterRoomStatus(room_num, "已住");
			if (-1 != alter_status) {
				String id_type = "身份证";
				String id_num = "951322";
				String name = "九九";
				String sex = "女";
				String phone = "98765432110";
				
				// 增加客人信息
				int add_status = addClient(id_type, id_num, name, sex, phone);
				if (-1 != add_status) {
					Timestamp check_in_date = new Timestamp(System.currentTimeMillis());
					Timestamp check_out_date = null;
					Timestamp expected_check_out_date = new Timestamp(2 * 24 * 60 * 60 * 1000 + check_in_date.getTime());
					//float guarantee_deposit = getGuarantee_deposit(room_num);
					float sum_owing = 0;
					
				    // 更新房间管理表
				    add_status = addManager(room_num, id_type, id_num, check_in_date, expected_check_out_date, check_out_date, sum_owing);
				    
					if (-1 != add_status) {	 
						 System.out.println("开房成功");
					 } else {
				         // 若客人信息已增加，但更新房间管理表失败
						 // 则回滚事务
						 con.rollback();
						 System.out.println("更新房间管理表失败");
					 }
				} else {
					// 若房间状态已改变，但增加客人信息失败
					// 则回滚事务
					con.rollback();
					System.out.println("增加客人信息失败");
				}
			} else {
				System.out.println("该房间已定或已住，请重新选择");
			}
		} finally {
			con.commit();
		}
	}
	
	/**
	 * 退房
	 */
	@Override
	public void checkOutRoom() throws SQLException {
		int room_num = 403;
		
		try {
			// 更新房间状态
			int alter_status = alterRoomStatus(room_num, "未定");
			if (-1 != alter_status) {
				Timestamp check_in_date = getCheck_in_date(room_num);
				Timestamp check_out_date = new Timestamp(System.currentTimeMillis());
				long check_in_time = (check_out_date.getTime() - check_in_date.getTime()) / 1000 / 60 / 60 / 24;
				float price = getPrice(room_num);
				// 开房时间不足一天算一天
				float sum_owing = (check_in_time > 0 ? check_in_time : 1) * price;
				
				alter_status = alterManager(room_num, check_in_date, check_out_date , sum_owing);
				if (-1 != alter_status) {
					System.out.println("退房成功");
				} else {
					// 若房间状态已改变，但更新房间管理表失败
					// 则回滚事务
					con.rollback();
					System.out.println("房间管理表更新失败");
				}
			} else {
				System.out.println("该房间当前未住");
			}
		} catch(SQLException e) {
			System.out.println("房间退订失败");
		} finally {
			con.commit();
		}
	}
		

	/**
	 * 订房
	 */
	@Override
	public void reserveRoom() throws SQLException {
		int room_num = 403;
		
		try {
			// 获取房间状态
			String room_status = getRoomStatus(room_num);
			
			if(room_status.equals("未定")) {
				// 更新房间状态
				int alter_status = alterRoomStatus(room_num, "已定");
				
				if(-1 != alter_status) {
					String id_type = "身份证";
					String id_num = "951322";
					String name = "九九";
					String sex = "女";
					String phone = "98765432110";
					
					// 更新客人信息
					int add_status = addClient(id_type, id_num, name, sex, phone);
				
					if(-1 != add_status) {
						Timestamp check_in_date = new Timestamp(System.currentTimeMillis());
						Timestamp expected_check_out_date = new Timestamp(2 * 24 * 60 * 60 * 1000 + check_in_date.getTime());
						
						// 添加房间订购信息
						alter_status = addReservation(room_num, id_type, id_num, 2, "已定", check_in_date, expected_check_out_date);
						
						if (-1 != alter_status) {
							System.out.println("房间预定成功");
						} else {
							con.rollback();
							System.out.println("更新预定信息失败");
						}
					} else {
						con.rollback();
						System.out.println("更新客人信息失败");
					}
				}else {
					System.out.println("更新房间状态失败");
				}
			}
		} catch(SQLException e) {
			System.out.println("预定房间失败" + e);
		} finally {
			con.commit();
		}
	}
	
	
	/**
	 * 退定
	 * @throws SQLException 
	 */
	@Override
	public void removeReservation() throws SQLException {
		int room_num = 403;
		
		try {
			// 获取房间状态
			String room_status = getRoomStatus(room_num);
			
			if(room_status.equals("已定")) {
				String id_type = "身份证";
				String id_num = "951322";
				
				// 更新房间状态
				int alter_status = alterRoomStatus(room_num, "未定");
				if(-1 != alter_status) {
					//更新房间预定表
					alter_status = alterReservation(room_num, id_type, id_num, 2, "已退");
					
					if(-1 != alter_status) {
						System.out.println("房间退订成功");
					} else {
						con.rollback();
						System.out.println("更新预定信息失败");
					}
				} else {
					System.out.println("房间退订失败");
				}
			}	
		} catch(SQLException e) {
			System.out.println("房间退订失败" + e);
		} finally {
			con.commit();
		}
		
	}
	
	
	/**
	 * 对预定的房间办理入住
	 * @throws SQLException 
	 */
	@Override
	public void reserveCheckingIn() throws SQLException {
		int room_num = 403;
		
		try {
			// 更新房间状态
			int alter_status = alterRoomStatus(room_num, "已住");
			
			if (-1 != alter_status) {
				String id_type = "身份证";
				String id_num = "951322";
				
		    	//更新房间预定表
				alter_status = alterReservation(room_num, id_type, id_num, 2, "已住");
				
				if(-1 != alter_status) {
					Timestamp check_in_date = new Timestamp(System.currentTimeMillis());
					Timestamp expected_check_out_date = getReservation(room_num, id_type, id_num);
					Timestamp check_out_date = null;
					float sum_owing = 0;
					
					// 添加入住信息
					int add_status = addManager(room_num, id_type, id_num, check_in_date, expected_check_out_date, check_out_date, sum_owing);
					if(-1 != add_status) {
						System.out.println("预定入住成功");
					} else {
						// 若添加入住信息失败
					    // 则回滚事务
						con.rollback();
						System.out.println("添加入住信息失败");
					}
				} else {
					// 若更新房间状态失败
				    // 则回滚事务
					con.rollback();
					System.out.println("更新预定信息失败");
				}
			} else {
			    System.out.println("更新房间状态失败");
	        }
		} catch (SQLResultEmptyException e) {
			System.out.println("您没有已预定的房间" + e);
		} catch (SQLException e){
			System.out.println("预定入住失败" + e);
		} finally {
			con.commit();
		}
	}
}
