package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Util.DBUtils;
import Util.DateUtil;
import db.FindGoodsById;
import db.IsGoodsExist;
import db.SearchPriceById;

public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBUtils.getConnection();
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			if (username != null) {
				
			String goodsid = request.getParameter("goodsid");
			String goods = new FindGoodsById().FindGoodsById(goodsid); 
			boolean isExist = new IsGoodsExist().isGoodsExist(goodsid,username);
			int price = new SearchPriceById().SearchPriceByid(goodsid);
			
			//如果该商品不在购物车，加入购物车
			if(isExist == false){
				int count =1;
				Random a = new Random(10);
				String orderid = new DateUtil().getTime() + String.valueOf(count)+String.valueOf((int)(Math.random()*10));
				String sql = "insert into shopcar values(?,?,?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, goods);
				stmt.setString(3, goodsid);
				stmt.setString(4, orderid);
				stmt.setLong(5, count);
				stmt.setLong(6, price);
				stmt.executeUpdate();
				
				//购买完成后跳转到shopcar页面
				response.sendRedirect("/ATWNorth/customer/shopcar.jsp");
			}
			//如果该商品已经存在购物车中，更改count +1；
			else{
				int count1 = new IsGoodsExist().getCount(goodsid)+1;
				price = price * count1;
				String sql = "update shopcar set count=?,price=? where goodsid=? ";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setLong(1, count1);
				stmt.setLong(2, price);
				stmt.setString(3, goodsid);
				stmt.executeUpdate();
				
				//购买完成后跳转到shopcar页面
				response.sendRedirect("/ATWNorth/customer/shopcar.jsp");
			}
	}else {
		//添加弹框；
		System.out.println("not login");
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
