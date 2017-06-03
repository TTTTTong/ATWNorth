package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DBUtils;

public class IsGoodsExist {
	
	//判断是否存在时要同时判断用户名和goodsid；
	public boolean isGoodsExist(String id,String username) throws SQLException {
		Connection conn = DBUtils.getConnection();
		
			String sql = "select goods from shopcar where goodsid=? and username=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}else{
				return false;
	}
 }
	public int getCount(String id,String username ) throws NumberFormatException, SQLException{
		Connection conn = DBUtils.getConnection();
		String sql = "select count from shopcar where goodsid=? and username=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setString(2, username);
		ResultSet rs = stmt.executeQuery();
		int i = 0;
		if (rs.next()) {
			i=rs.getInt(1);
		}
		return i;
	}
}