package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	
	//后续写在配置文件中
	 public static final String driverName = "com.mysql.cj.jdbc.Driver";
	 public static final String dbURL = "jdbc:mysql://localhost:3306/hotel_guest?serverTimezone=GMT%2B8";
	 public static final String userName = "root";
	 public static final String password = "12345678";
	 static{
		 try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	 
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("数据库连接成功");
		}catch(SQLException e) {
			System.out.println("数据库连接失败： " + e);
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
			System.out.println("数据库关闭成功");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Connection con = JDBC.getConnection();
		//JDBC.closeConnection(con);
	}

}
