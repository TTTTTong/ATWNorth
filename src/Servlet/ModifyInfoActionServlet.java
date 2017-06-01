package Servlet;

import org.apache.struts.action.*;
import javax.servlet.http.*;
import java.sql.*;


public class ModifyInfoActionServlet  extends Action{
	//唯一的用户方法execute
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm,HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws ClassNotFoundException, SQLException{
		String phone = servletRequest.getParameter("phone");
		String address = servletRequest.getParameter("address");
		System.out.println(phone+address);
		
		return actionMapping.findForward("null");
	}
}
