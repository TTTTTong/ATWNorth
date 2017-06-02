package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.DBUtils;

public class GetNextGoodsId {
	public String  GetNextGoodsId() {
		 String count = null;
		Connection conn = DBUtils.getConnection();
		String sql = "select count(goodsid)+1 from goods";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()){
				 count = "1"+rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	}
public static void main(String[] args) {
	
	}
}
