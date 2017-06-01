package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.User;
import Util.DBUtils;
import Util.DateUtil;

public class RegisterActionServlet extends Action{
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm,HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws ClassNotFoundException, SQLException, IOException{
		
	
		boolean flag = false;
		String username = servletRequest.getParameter("username");
		String phone = servletRequest.getParameter("phonenumber");
		String regdate = new DateUtil().getRegTime();
		String pwd1 = new String(servletRequest.getParameter("password1"));
		String pwd2 = new String(servletRequest.getParameter("password2"));
		String address = servletRequest.getParameter("address");
		
		
		if(pwd1.equals(pwd2) == false){
			servletResponse.getWriter().print("<script>alert(\"password wrong!\");</script>");
			System.out.println("password error");
		}else {
			flag = true;
			
			Connection conn = DBUtils.getConnection();
			try {
				String sql = "insert into myuser values(?,?,?,?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, pwd1);
				stmt.setString(3, phone);
				stmt.setString(4, address);
				stmt.setString(5, regdate);
				stmt.setString(6, " ");
				stmt.setLong(7, 0);
				stmt.executeUpdate();
				
				System.out.println("注册成功"+username);
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				conn.close();
			}	
		}
		//处理转发  
		if(flag){
			servletResponse.sendRedirect("/ATWNorth/login.jsp");
			return actionMapping.findForward("null");
		}else{
			//servletResponse.getWriter().print("<script>alert(\"password wrong!\");</script>");
			//servletResponse.sendRedirect("/ATWNorth/register.jsp");
			return actionMapping.findForward("null");
		}
    }
}