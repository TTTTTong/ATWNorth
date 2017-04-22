package db;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindGoodsById {
	public  String FindGoodsById(String id) throws SQLException{
		Connection conn = DBUtils.getConnection();

		String goods = "";
		try {
			Statement stmt = conn.createStatement();
			String sql = "select goods from goods where goodsid='id'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				goods = rs.getString(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询商品名称失败");
		}finally {
			conn.close();
		}
		return goods;
	}
}
