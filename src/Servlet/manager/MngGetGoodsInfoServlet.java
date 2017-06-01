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


public class MngGetGoodsInfoServlet extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public MngGetGoodsInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goodsid = request.getParameter("goodsid");
		Connection conn = DBUtils.getConnection();
		String sql = "select *from goods where goodsid=?";
		PreparedStatement stmt;
	
		HttpSession session = request.getSession();
		GoodsInfo goodsInfo = new GoodsInfo();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, goodsid);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				goodsInfo.setGoodsname(rs.getString("goodsname"));
				goodsInfo.setGoodsid(rs.getString("goodsid"));
				goodsInfo.setSales(rs.getInt("sales"));
				goodsInfo.setPrice(rs.getInt("price"));
				goodsInfo.setDscb(rs.getString("dscb"));
				goodsInfo.setImage(rs.getString("image"));
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
		session.setAttribute("goodsInfo", goodsInfo);
		response.sendRedirect("/ATWNorth/ui 2.0/manager/goodsInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
