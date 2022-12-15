package com.travelzilla.models;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId ;
	private String busType;
	private String busNumber;
	private Integer capacity;
	private Integer availabeSeat;
	
	@ManyToOne
	@JsonIgnore
	private Route route;
	
	@ManyToOne
	@JsonIgnore
	private Travels travel;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bus")
	List<TicketDetails> ticketdetails;

	public Bus(Integer busId, String busType, String busNumber, Integer capacity, Integer availabeSeat, Route route,
			Travels travel, List<TicketDetails> ticketdetails) {
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

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
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

	public List<TicketDetails> getTicketdetails() {
		return ticketdetails;
	}

	public void setTicketdetails(List<TicketDetails> ticketdetails) {
		this.ticketdetails = ticketdetails;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", busNumber=" + busNumber + ", capacity=" + capacity
				+ ", availabeSeat=" + availabeSeat + ", route=" + route + ", travel=" + travel + ", ticketdetails="
				+ ticketdetails + "]";
	}
	
	
	
	
	
	
	
}
