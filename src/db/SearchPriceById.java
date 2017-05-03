package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DBUtils;

public class SearchPriceById {
	public int SearchPriceByid(String id) throws SQLException {
		Connection conn = DBUtils.getConnection();
		String sql = "select price from GOODS where GOODSID=?";
		PreparedStatement stmt;
		int price = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				price = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return price;
	}
}
