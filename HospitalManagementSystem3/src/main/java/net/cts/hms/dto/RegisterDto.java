package net.cts.hms.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class RegisterDto {
//	private String name;
//	private String username;
//	private String email;
//	private String password;
//	
//
//}


public class RegisterDto {
	 
	private String firstName;
 
	private String lastName;
 
	private String emailId;
 
	private String password;
	
	private String role;
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
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
		return "RegisterDto [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", password="
				+ password + ", role=" + role + "]";
	}
 
}
