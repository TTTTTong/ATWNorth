package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.User;

public class RegisterActionServlet extends Action{
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm,HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws ClassNotFoundException, SQLException, IOException{
		
	
		boolean loginflag = false;
		
		String pwd1 = servletRequest.getParameter("password1");
		String pwd2 = servletRequest.getParameter("password2");
		
		if(pwd1 != pwd2 ){
			servletResponse.getWriter().print("<script>alert(\"password wrong!\");</script>") ;
		}else {
			loginflag = true;
		}
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:127.0.0.1:1521:ORCL";
		String username="scott";
		String pwd="tiger";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url,username,pwd);
			Statement stmt=conn.createStatement();
			String sql="insert into MYUSER(USERNAME,PASSWORD,PHONE) values('"
			+servletRequest.getParameter("username")+"','"+servletRequest.getParameter("password1")+"'"
					+ ",'"+servletRequest.getParameter("phonenumber")+"')";
			
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			conn.close();
		}
	
		if(loginflag){
			return actionMapping.findForward("success");	
	}else{
		return actionMapping.findForward("error");
	}

}
}