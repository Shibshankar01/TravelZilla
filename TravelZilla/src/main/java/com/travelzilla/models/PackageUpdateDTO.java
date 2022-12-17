package com.travelzilla.models;

public class PackageUpdateDTO {

	private Integer updatedHotel_Id;
	private Double updatedPackageCost;
	private PackageStatus updatedPackageStatus;
	
	public PackageUpdateDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PackageUpdateDTO(Integer updatedHotel_Id, Double updatedPackageCost, PackageStatus updatedPackageStatus) {
		super();
		this.updatedHotel_Id = updatedHotel_Id;
		this.updatedPackageCost = updatedPackageCost;
		this.updatedPackageStatus = updatedPackageStatus;
	}


	public Integer getUpdatedHotel_Id() {
		return updatedHotel_Id;
	}


	public void setUpdatedHotel_Id(Integer updatedHotel_Id) {
		this.updatedHotel_Id = updatedHotel_Id;
	}


	public Double getUpdatedPackageCost() {
		return updatedPackageCost;
	}


	public void setUpdatedPackageCost(Double updatedPackageCost) {
		this.updatedPackageCost = updatedPackageCost;
	}


	public PackageStatus getUpdatedPackageStatus() {
		return updatedPackageStatus;
	}


	public void setUpdatedPackageStatus(PackageStatus updatedPackageStatus) {
		this.updatedPackageStatus = updatedPackageStatus;
	}
	
	
	
	
}
