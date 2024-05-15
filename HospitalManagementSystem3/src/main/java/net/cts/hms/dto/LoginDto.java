package net.cts.hms.dto;

public class LoginDto {
	
	private String emailId;
	private String password;
	private String role;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "LoginDto [emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}