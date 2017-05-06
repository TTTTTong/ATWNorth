package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.DBUtils;


public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBUtils.getConnection();
		String orderid = request.getParameter("orderid");
		String sql = "select * from shopcar where orderid=?";
		String sql1="select *from myuser where username=?";
		String sql2="insert into orderlist values(?,?,?,?,?,?,?)";
		String sql3 = "delete from shopcar where orderid=?";
		
		PreparedStatement stmt;
		PreparedStatement stmt1;
		PreparedStatement stmt2;
		PreparedStatement stmt3;
		
		String username = "";
		String goods = "";
		String phone = "";
		String address = "";
		int count = 0;
		int price = 0;
		
		try {
			//获取shopcar中商品信息
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, orderid);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
			username = rs.getString(1);
			goods = rs.getString(2);
			count = rs.getInt(5);
		    price = rs.getInt(6);
		}
			
			//获取用户信息
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1, username);
			ResultSet rs1 = stmt1.executeQuery();
			
			if (rs1.next()) {
			phone = rs1.getString(3);
		    address = rs1.getString(4);
	} 	
			//把完整信息的订单提交到数据库
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, username);
			stmt2.setString(2, phone);
			stmt2.setString(3, goods);
			stmt2.setString(4, address);
			stmt2.setString(5, orderid);
			stmt2.setInt(6, count);
			stmt2.setInt(7, price);
			stmt2.executeUpdate();
			
			//从shopcar中删除此订单
			//重用DeleteOrderServlet会产生
			//Cannot call sendRedirect() after the response has been committed
			//new DeleteOrderServlet().doGet(request, response);
			stmt3 = conn.prepareStatement(sql3);
			stmt3.setString(1, orderid);
			stmt3.executeUpdate();
			
			
			//跳转到已完成订单页
			response.sendRedirect("/ATWNorth/ui 1.0/customer/order.jsp");
			
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
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
