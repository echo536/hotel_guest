package db;

import java.sql.Connection;
import java.sql.SQLException;

import model.room.Room;

public class Dao extends BaseDao{

	public Dao() { }

	public Dao(Connection con) throws SQLException { 
		super(con);
	}
	
	public Room[] getRoomTypeOne() {
		String sql = "SELECT * FROM `room` WHERE `type` = '豪华双人间';";
		return getRoom(sql);
	}
	
	public Room[] getRoomTypeTwo() {
		String sql = "SELECT * FROM `room` WHERE `type` = '豪华单人间';";
		return getRoom(sql);
	}
	
	public Room[] getRoomTypeThree() {
		String sql = "SELECT * FROM `room` WHERE `type` = '标准';";
		return getRoom(sql);
	}
	
	public Room[] getRoomTypeFour() {
		String sql = "SELECT * FROM `room` WHERE `type` = '双人间';";
		return getRoom(sql);
	}
	
	public Room[] getRoomTypeFive() {
		String sql = "SELECT * FROM `room` WHERE `type` = '单人间';";
		return getRoom(sql);
	}
	
	public boolean alterRoomStatus(int room_num, String roomStatus) {
		String sql = String.format("ALTER `room` SET `status` = '{}' WHERE `room_num` = {};", room_num, roomStatus);
		return alterRoom(sql);
	}
	
	/*public int getRoom_num() {
		
	}
	public String getRoomType() {
		
	}
	public float getRoomPrice() {
		
	}
	public float getRoomGuarantee_deposit() {
		
	}
	public String getRoomStatus() {
		
	}
	
	
	
	public String getClientId_type() {
		
	}
	public String getClientId_num() {
		
	}
	public String getClientName() {
		
	}
	public String getClientSex() {
		
	}
	public String getClientPhone() {
		
	}*/
	
	
	
	
}
