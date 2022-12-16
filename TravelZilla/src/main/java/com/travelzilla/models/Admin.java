package com.travelzilla.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.swing.ListSelectionModel;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminID;
	
	@NotBlank
	@Max(value = 20)
	private String adminName;
	
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 15, message = "Password should be minimum 8 and maximum 15 characters long")
	private String password;
	
	@Size(min = 10, max = 10, message = "Mobile numbers should be 10 digit long")
	private String mobile;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "admin" ,cascade = CascadeType.ALL)
	private List<Report> reports = new ArrayList<>();
	
	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminName=" + adminName + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", user=" + user + "]";
	}
	
	

}
