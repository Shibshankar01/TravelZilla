package com.travelzilla.models;

public class LoginDTO {

	private String email;
	private String password;
	private UserType userType;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + ", userType=" + userType + "]";
	}
	
	
}
