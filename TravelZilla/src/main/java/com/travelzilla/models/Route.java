package com.travelzilla.models;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer routeId;
	private String routeFrom;
	private String routeTo;
	private LocalDateTime  departureTime;
	private LocalDateTime  arrivalTime;
	private LocalDateTime  doj;
	private String pickupPoint;
	private double fare;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Packages> packageList;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bus> busList;

	
//	Route and Bus Management
//	create route
//	delete route
//	modify route
//	
//	if pacage add rought.package
	
//	 View Routes
	
	
	
	public Route(Integer routeId, String routeFrom, String routeTo, LocalDateTime departureTime,
			LocalDateTime arrivalTime, LocalDateTime doj, String pickupPoint, double fare, List<Packages> packageList,
			List<Bus> busList) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
		this.pickupPoint = pickupPoint;
		this.fare = fare;
		this.packageList = packageList;
		this.busList = busList;
	}


public Route() {
	super();
	System.out.println("ajaycvbnm,.");
}


public Integer getRouteId() {
	return routeId;
}


public void setRouteId(Integer routeId) {
	this.routeId = routeId;
}


public String getRouteFrom() {
	return routeFrom;
}


public void setRouteFrom(String routeFrom) {
	this.routeFrom = routeFrom;
}


public String getRouteTo() {
	return routeTo;
}


public void setRouteTo(String routeTo) {
	this.routeTo = routeTo;
}


public LocalDateTime getDepartureTime() {
	return departureTime;
}


public void setDepartureTime(LocalDateTime departureTime) {
	this.departureTime = departureTime;
}


public LocalDateTime getArrivalTime() {
	return arrivalTime;
}


public void setArrivalTime(LocalDateTime arrivalTime) {
	this.arrivalTime = arrivalTime;
}


public LocalDateTime getDoj() {
	return doj;
}


public void setDoj(LocalDateTime doj) {
	this.doj = doj;
}


public String getPickupPoint() {
	return pickupPoint;
}


public void setPickupPoint(String pickupPoint) {
	this.pickupPoint = pickupPoint;
}


public double getFare() {
	return fare;
}


public void setFare(double fare) {
	this.fare = fare;
}


public List<Packages> getPackageList() {
	return packageList;
}


public void setPackageList(List<Packages> packageList) {
	this.packageList = packageList;
}


public List<Bus> getBusList() {
	return busList;
}


public void setBusList(List<Bus> busList) {
	this.busList = busList;
}


@Override
public String toString() {
	return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", departureTime="
			+ departureTime + ", arrivalTime=" + arrivalTime + ", doj=" + doj + ", pickupPoint=" + pickupPoint
			+ ", fare=" + fare + ", packageList=" + packageList + ", busList=" + busList + "]";
}
	

	
}

