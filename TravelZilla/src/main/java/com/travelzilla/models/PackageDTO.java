package com.travelzilla.models;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PackageDTO {

//	@NotNull(message = "Package Name Cannot Be Null!")
//	@Size(min = 10, max = 100, message = "Package Name Length must be between 10 to 100 characters.")
	private String packageName;

//	@NotNull(message = "Package Description Cannot Be Null!")
//	@Size(min = 10, max = 1000, message = "Package Description Length must be between 10 to 1000 characters.")
	private String packageDescription;
//
//	@NotNull(message = "Route ID Cannot Be Null!")
//	@Min(value = 1, message = "Invalid Route ID, must be > 0")
	private Integer routeId;

//	@NotNull(message = "Hotel ID Cannot Be Null!")
	private Integer hotel_Id;

//	@NotNull(message = "Bus Cannot be Null")
	private Integer busId;

//	@NotNull(message = "Package Cost Cannot be Null")
//	@Min(value = 2000, message = "Package Cost Cannot be Less Than 2000.")
	private Double packageCost;
	
	private Integer packageCapacity;
	
	public PackageDTO() {
		// TODO Auto-generated constructor stub
	}

	public PackageDTO(
			@NotNull(message = "Package Name Cannot Be Null!") @Size(min = 10, max = 100, message = "Package Name Length must be between 10 to 100 characters.") String packageName,
			@NotNull(message = "Package Description Cannot Be Null!") @Size(min = 10, max = 1000, message = "Package Description Length must be between 10 to 1000 characters.") String packageDescription,
			@NotNull(message = "Route ID Cannot Be Null!") @Min(value = 1, message = "Invalid Route ID, must be > 0") Integer routeId,
			@NotNull(message = "Hotel ID Cannot Be Null!") Integer hotel_Id,
			@NotNull(message = "Bus Cannot be Null") Integer busId,
			@NotNull(message = "Package Cost Cannot be Null") @Min(value = 2000, message = "Package Cost Cannot be Less Than 2000.") Double packageCost) {
		super();
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.routeId = routeId;
		this.hotel_Id = hotel_Id;
		this.busId = busId;
		this.packageCost = packageCost;
	}

	public Integer getPackageCapacity() {
		return packageCapacity;
	}

	public void setPackageCapacity(Integer packageCapacity) {
		this.packageCapacity = packageCapacity;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getHotel_Id() {
		return hotel_Id;
	}

	public void setHotel_Id(Integer hotel_Id) {
		this.hotel_Id = hotel_Id;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public Double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Double packageCost) {
		this.packageCost = packageCost;
	}

	@Override
	public String toString() {
		return "PackageDTO [packageName=" + packageName + ", packageDescription=" + packageDescription + ", routeId="
				+ routeId + ", hotel_Id=" + hotel_Id + ", busId=" + busId + ", packageCost=" + packageCost + "]";
	}
	
	

}
