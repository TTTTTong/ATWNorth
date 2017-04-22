package Servlet;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBUtils;
import db.FindGoodsById;
import db.IsGoodsExist;

public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			String goodsid = request.getParameter("goodsid");
			String goods = new FindGoodsById().FindGoodsById(goodsid); 
			boolean isExist = new IsGoodsExist().isGoodsExist(goodsid);
			
			Connection conn = DBUtils.getConnection();
			Statement stmt = conn.createStatement();
			//如果该商品不在购物车，购买
			if(!isExist){
				int count =1;
				String orderid = goodsid + String.valueOf(count);
				String sql = "insert into shopcar(username,goods,goodsid,orderid,count) "
						+ "values(+username+,+goods+,+goodsid+,+orderid+,+count+)";
				stmt.executeUpdate(sql);
			}
			//如果该商品已经存在购物车中，更改count +1；
			else{
				int count1 = new IsGoodsExist().getCount(goodsid)+1;
				String sql = "update shopcar set count=count1 where goodsid=goodsid ";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		//	conn.close();
		}
		
		
		System.out.println("buyaction");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
