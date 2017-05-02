package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnection(){
		Connection conn=null;
	
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String username="scott";
			String pwd="tiger";
			String url="jdbc:oracle:thin:127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			try {
				throw new Exception("Can not get connection", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				throw new Exception("Can not get connection", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return conn;
}
	public static void main(String[] args) {
		
		System.out.println(new DBUtils().getConnection());
	}
}
