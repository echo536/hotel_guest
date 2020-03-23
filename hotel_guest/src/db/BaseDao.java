package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import model.client.Client;
import model.room.Manager;
import model.room.Reservation;
import model.room.Room;
import model.user.User;

public class BaseDao {
	private Connection con = null;
	
	public BaseDao() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseDao(Connection con) throws SQLException { 		
		this.con = con;
	}
	
	public void initDB() throws SQLException {
		con.setAutoCommit(false);
	}

	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Room[] getRoom(String sql) {
		Room[] room = null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			rs.last();
			int row = rs.getRow();
			room = new Room[row];
			rs.first();
			int i = 0;
			do {
			    room[i++] = new Room(rs.getInt("room_num"), rs.getString("type"), rs.getFloat("price"), 
			    		rs.getFloat("guarantee_deposit"), rs.getString("status"));
			} while(rs.next());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return room;
	}
	
	public boolean insertRoom(String sql) {
		boolean status = false;
		
		return status;
	}
	
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public boolean alterRoom(String sql) {
		boolean status = false;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.executeUpdate(sql);
			status = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Client[] getClient(String sql) throws SQLException {
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		rs.last();
		int row = rs.getRow();
		Client[] client = new Client[row];
		rs.first();
		int i = 0;
		while(rs.next()) {
		    client[i] = new Client(rs.getString("id_type"), rs.getString("id_num"), 
		    		rs.getString("name"), rs.getString("sex"), rs.getString("phone"));
		    i++;
		}
		
		return client;
	}

	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public User[] getUser(String sql) throws SQLException {
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		rs.last();
		int row = rs.getRow();
		User[] user = new User[row];
		rs.first();
		int i = 0;
		while(rs.next()) {
		    user[i] = new User(rs.getInt("employee_id"), rs.getString("name"), 
		    		rs.getString("sex"), rs.getString("occupation"), rs.getString("phone"));
		    i++;
		}
		
		return user;
	}
	
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Reservation[] getReservation(String sql) throws SQLException {
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		rs.last();
		int row = rs.getRow();
		Reservation[] reservation = new Reservation[row];
		rs.first();
		int i = 0;
		while(rs.next()) {
		    reservation[i] = new Reservation(rs.getInt("id"), rs.getInt("employee_id"),
		    		rs.getInt("room_num"), rs.getString("id_type"), rs.getString("id_num"),
		    		rs.getTimestamp("chekc_in_date"), rs.getTimestamp("expected_check_out_date"),
		    		rs.getString("status"));
		    i++;
		}
		
		return reservation;
	}
		
	/**
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Manager[] getManager(String sql) throws SQLException {
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		rs.last();
		int row = rs.getRow();
		Manager[] manager = new Manager[row];
		rs.first();
		int i = 0;
		while(rs.next()) {
			manager[i] = new Manager(rs.getInt("employee_id"), rs.getInt("room_num"),
		    		rs.getString("id_type"), rs.getString("id_num"),rs.getTimestamp("chekc_in_date"),
		    		rs.getTimestamp("expected_check_out_date"), rs.getTimestamp("check_out_date"),
		    		rs.getFloat("sum_owing"));
		    i++;
		}
		
		return manager;
	}
}
