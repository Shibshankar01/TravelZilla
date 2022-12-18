package com.travelzilla.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BookingDTO {

	@NotNull(message = "Package ID Cannot Be Null")
	private Integer packageId;
	
	@NotNull(message = "Customer ID Cannot Be Null")
	private Integer customerId;
	
	@NotNull(message = "Number Of Person Cannot Be Null")
	@Min(value = 1, message = "Number Of Person Should Be Atleast 1")
	private Integer noOfPersons;
	public BookingDTO() {
		// TODO Auto-generated constructor stub
	}
	public BookingDTO(Integer packageId, Integer customerId, Integer noOfPersons) {
		super();
		this.packageId = packageId;
		this.customerId = customerId;
		this.noOfPersons = noOfPersons;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	
	
}
