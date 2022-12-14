package com.travelzilla.models;

public class Customer {
	
	private Integer customerId;
	private String customerName;
	private String customerPassword;
	private String address;
	private String email;
	private String mobile;
	private Integer userId;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	

	public Customer(Integer customerId, String customerName, String customerPassword, String address, String email,
			String mobile, Integer userId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.userId = userId;
	}



	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", address=" + address + ", email=" + email + ", mobile=" + mobile + ", userId="
				+ userId + "]";
	}
	
	
	

}
