package Bean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class LoginActionForm  extends ActionForm{

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//数据验证方法
	public ActionErrors validate(ActionMapping actionMapping,
			HttpServletRequest httpServletRequest){
		return null;
	}
	
	//数据充值方法
	public void reset(ActionMapping actionMapping,
			HttpServletRequest httpServletRequest){
		
	}
}