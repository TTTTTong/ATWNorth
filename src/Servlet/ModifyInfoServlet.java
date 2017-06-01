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

public class ModifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		System.out.println(phone+address);
		Connection conn = DBUtils.getConnection();
		String sql = "update myuser set phone=?,address=? where username=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, phone);
			stmt.setString(2, address);
			stmt.setString(3, username);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.getWriter().print("<script>alert(\"修改成功!\");</script>");
		System.out.println(username+"modify info success");
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
