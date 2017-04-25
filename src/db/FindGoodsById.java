package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindGoodsById {
	public  String FindGoodsById(String id) throws SQLException{
		Connection conn = DBUtils.getConnection();

		String goods = "b";
		try {
			String sql = "select goodsname from GOODS where GOODSID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				goods = rs.getString(1);
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
