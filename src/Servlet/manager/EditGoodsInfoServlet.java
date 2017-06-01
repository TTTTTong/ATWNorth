package Servlet.manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.prism.Image;

import Bean.GoodsInfo;
import Util.DBUtils;
import jdk.nashorn.internal.objects.annotations.Where;


public class EditGoodsInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public EditGoodsInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit");
		Connection conn = DBUtils.getConnection();
		String goodsname = request.getParameter("goodsname");
		String goodsid = request.getParameter("goodsid");
		int price = Integer.parseInt(request.getParameter("price"));
		String dscb = request.getParameter("dscb");
		String sql = "update goods set goodsname=?,price=?,dscb=? where goodsid=?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, goodsname);
			stmt.setInt(2, price);
			stmt.setString(3, dscb);
			stmt.setString(4, goodsid);
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
