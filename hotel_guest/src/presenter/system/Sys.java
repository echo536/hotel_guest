package presenter.system;

import java.sql.Connection;
import java.sql.SQLException;

import db.JDBC;
import model.room.Room;
import model.user.NormalUser;
import view.RightPanel;
import view.MainFrame;
import view.NorthPanel;
import view.LeftPanel;
import db.Dao;

public class Sys implements Runnable{
	Dao dao = null;
	private Room[] roomTypeOne = null;
	private Room[] roomTypeTwo = null;
	private Room[] roomTypeThree = null;
	private Room[] roomTypeFour = null;
	private Room[] roomTypeFive = null;
	
	public Sys() throws SQLException {
		Connection con = JDBC.getConnection();
		dao = new Dao(con);
		MainFrame mainframe = new MainFrame(this, "123", "123");
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-b method stub
		
		/*NormalUser normaluser = new NormalUser(con);
		normaluser.initDB();
		//normaluser.getRoomStatus();
		//normaluser.checkInRoom();
		//normaluser.checkOutRoom();
		//normaluser.reserveRoom();
		//normaluser.removeReservation();
		//normaluser.reserveCheckingIn();
		JDBC.closeConnection(con);*/
		
		new Sys();
	}
	
	public Room[] getRoomTypeOne() {
		roomTypeOne = dao.getRoomTypeOne();
		
		return roomTypeOne;
	}
	
	public Room[] getRoomTypeTwo() {
		roomTypeTwo = dao.getRoomTypeTwo();
		
		return roomTypeTwo;
	}
	
	public Room[] getRoomTypeThree() {
		roomTypeThree = dao.getRoomTypeThree();
		
		return roomTypeThree;
	}
	
	public Room[] getRoomTypeFour() {
		roomTypeFour = dao.getRoomTypeFour();
		
		return roomTypeFour;
	}
	
	public Room[] getRoomTypeFive() {
		roomTypeFive = dao.getRoomTypeFive();
		
		return roomTypeFive;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
