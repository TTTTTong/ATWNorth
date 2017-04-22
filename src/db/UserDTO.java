package db;

public class UserDTO {

	 String username;
	 String password;
	
	public UserDTO(){
	}
	
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
	public String toString() {
		return "UserDAO [ username=" + username + ", password=" + password + "]";
	}
}
