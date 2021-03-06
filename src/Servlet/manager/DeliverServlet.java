package Servlet.manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.DBUtils;


public class DeliverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		Connection conn = DBUtils.getConnection();
		
		String orderid = request.getParameter("orderid");
		try {
			String sql = "update orderlist set state=? where orderid=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			String s = "已发货";
			stmt.setString(1, s);
			stmt.setString(2, orderid);
			stmt.executeUpdate();
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
		response.getWriter().print("<script>alert(\"Successful operation!\");</script>");
		System.out.println("发货成功"+orderid);
		//response.sendRedirect("/ATWNorth/ui 2.0/manager/mng_main.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
