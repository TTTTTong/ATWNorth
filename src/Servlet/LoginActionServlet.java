package Servlet;

import org.apache.struts.action.*;
import Bean.LoginActionForm;
import Util.DBUtils;
import Util.DateUtil;

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
		Connection conn = DBUtils.getConnection();
		
		try {
			Statement stmt=conn.createStatement();
			String sql = "select * from MYUSER where username ='"
			+loginActionForm.getUsername()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			//记录用户登录时间
			String sql1 = "update myuser set lastlogin=? where username=? ";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1, new DateUtil().getLogTime());
			stmt1.setString(2, loginActionForm.getUsername());
			stmt1.executeUpdate();
			
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
			if(loginActionForm.getUsername().equals("root")){
				servletResponse.sendRedirect("/ATWNorth/ui 2.0/manager/mng_main.jsp");
			}else{
			servletResponse.sendRedirect("/ATWNorth/ui 2.0/customer/cus_main.jsp");
			}
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
