package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsGoodsExist {
	public boolean isGoodsExist(String id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		
			String sql = "select goods from shopcar where goodsid=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}else{
				return false;
	}
 }
	public int getCount(String id) throws NumberFormatException, SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "select count from shopcar where goodsid=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		int i = 0;
		if (rs.next()) {
			i=rs.getInt(1);
		}
		return i;
	}
}