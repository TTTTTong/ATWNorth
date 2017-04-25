package Servlet;

import org.apache.struts.action.*;
import Bean.LoginActionForm;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import javax.servlet.http.HttpSession;

public class LoginActionServlet  extends Action{
	//唯一的用户方法execute
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm,HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws ClassNotFoundException, SQLException{
		//自动获取ActionForm实例
		LoginActionForm loginActionForm = (LoginActionForm) actionForm;
		
		//获取session
		HttpSession session = servletRequest.getSession();
		
		boolean loginflag = false;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:127.0.0.1:1521:ORCL";
		String username="scott";
		String pwd="tiger";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url,username,pwd);
			Statement stmt=conn.createStatement();
			String sql = "select * from MYUSER where username ='"
			+loginActionForm.getUsername()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			//处理结果集
			while(rs.next()){
				if(loginActionForm.getPassword().equals(rs.getString("password"))){
					loginflag = true;
				}
			}
		} catch (Exception sqlexl) {
			// TODO: handle exception
			sqlexl.printStackTrace();
		}
		finally{
			conn.close();
		}
	
	//处理转发
	if(loginflag){
		session.setAttribute("username", loginActionForm.getUsername());
		try {
			servletResponse.sendRedirect("/ATWNorth/customer/cus_main.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		//不执行
		return actionMapping.findForward("null");
	}else{
		return actionMapping.findForward("error");
	}
	
 }
}
