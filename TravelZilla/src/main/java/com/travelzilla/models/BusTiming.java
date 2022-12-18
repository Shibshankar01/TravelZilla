package com.travelzilla.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class BusTiming {
	
	private LocalTime  departureTime;
	private LocalTime  arrivalTime;
	private LocalDate  doj;
	
	
	public BusTiming() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusTiming(LocalTime departureTime, LocalTime arrivalTime, LocalDate doj) {
		super();
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.doj = doj;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "BusTiming [departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", doj=" + doj + "]";
	}
	
	

}
