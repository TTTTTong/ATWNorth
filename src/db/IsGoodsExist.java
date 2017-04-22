package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsGoodsExist {
	public boolean isGoodsExist(String id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		
			String sql = "select goods from shopcar where goodsid='id'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}else{
				return false;
	}
 }
	public int getCount(String id) throws NumberFormatException, SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "select count from shopcar where goodsis='id'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		int i = 0;
		if (rs.next()) {
			i=rs.getInt(0);
		}
		return i;
	}
}