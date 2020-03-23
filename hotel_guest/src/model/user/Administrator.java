package model.user;

import java.sql.Connection;
import java.sql.SQLException;

import presenter.operate.Manager;

public class Administrator extends NormalUser implements Manager{

	Administrator(Connection con) throws SQLException {
		super(con);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRoom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SubtractRoom() {
		// TODO Auto-generated method stub
		
	}

}
