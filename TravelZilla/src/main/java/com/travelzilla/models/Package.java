package com.travelzilla.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Package {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer package_Id ;

	private String type;
	@ManyToOne
	@JsonIgnore
	private Route route;
	public Package(Integer package_Id, String type, Route route) {
		super();
		this.package_Id = package_Id;
		this.type = type;
		this.route = route;
	}
	public Package() {
		super();
	}
	public Integer getPackage_Id() {
		return package_Id;
	}
	public void setPackage_Id(Integer package_Id) {
		this.package_Id = package_Id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "Package [package_Id=" + package_Id + ", type=" + type + ", route=" + route + "]";
	}
	
	
	
	

}
