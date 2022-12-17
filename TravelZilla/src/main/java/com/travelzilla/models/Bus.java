package com.travelzilla.models;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;


import javax.persistence.Entity;

import javax.persistence.*;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId ;
	private BusType busType;
	private String busNumber;
	private Integer capacity;
	private Integer availabeSeat;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Route route;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Travels travel;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<TicketDetails> ticketdetails= new HashSet<>();

	public Bus(Integer busId, BusType busType, String busNumber, Integer capacity, Integer availabeSeat, Route route,
			Travels travel, Set<TicketDetails> ticketdetails) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
		this.availabeSeat = availabeSeat;
		this.route = route;
		this.travel = travel;
		this.ticketdetails = ticketdetails;
	}

	public Bus() {
		super();
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public BusType getBusType() {
		return busType;
	}

	public void setBusType(BusType busType) {
		this.busType = busType;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getAvailabeSeat() {
		return availabeSeat;
	}

	public void setAvailabeSeat(Integer availabeSeat) {
		this.availabeSeat = availabeSeat;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Travels getTravel() {
		return travel;
	}

	public void setTravel(Travels travel) {
		this.travel = travel;
	}

	public Set<TicketDetails> getTicketdetails() {
		return ticketdetails;
	}

	public void setTicketdetails(Set<TicketDetails> ticketdetails) {
		this.ticketdetails = ticketdetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availabeSeat, busId, busNumber, busType, capacity, ticketdetails);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bus other = (Bus) obj;
		return Objects.equals(availabeSeat, other.availabeSeat) && Objects.equals(busId, other.busId)
				&& Objects.equals(busNumber, other.busNumber) && busType == other.busType
				&& Objects.equals(capacity, other.capacity) && Objects.equals(ticketdetails, other.ticketdetails);
	}

	
	
	

	
	

}
