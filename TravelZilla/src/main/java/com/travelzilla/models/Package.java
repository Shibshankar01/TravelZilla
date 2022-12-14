package com.travelzilla.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int packageId;

	@NotNull(message = "Package Name Cannot Be Null!")
	@Size(min = 10, max = 100, message = "Package Name Length must be between 10 to 100 characters.")
	private String packageName;

	@NotNull(message = "Package Description Cannot Be Null!")
	@Size(min = 10, max = 1000, message = "Package Description Length must be between 10 to 1000 characters.")
	private String packageDescription;

	@NotNull(message = "Route ID Cannot Be Null!")
	@Min(value = 1, message = "Invalid Route ID, must be > 0")
	private int routeId;

	@NotNull(message = "Hotel Cannot Be Null!")
	private Hotel hotel;

	@NotNull(message = "Bus Cannot be Null")
	
	private Bus bus;

	@NotNull(message = "Package Cost Cannot be Null")
	@Min(value = 2000, message = "Package Cost Cannot be Less Than 2000.")
	private int packageCost;

	public Package() {
		// TODO Auto-generated constructor stub
	}

	public Package(int packageId, String packageName, String packageDescription, int routeId, Hotel hotel, Bus bus,
			int packageCost) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.routeId = routeId;
		this.hotel = hotel;
		this.bus = bus;
		this.packageCost = packageCost;

	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
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

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(int packageCost) {
		this.packageCost = packageCost;
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", routeId=" + routeId + ", hotel=" + hotel + ", bus=" + bus + ", packageCost="
				+ packageCost + "]";
	}

}
