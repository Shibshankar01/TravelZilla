package com.travelzilla.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketdetails_Id ;

	private String type;
	
	@ManyToOne
	@JsonIgnore
	private Bus bus;

	public Integer getTicketdetails_Id() {
		return ticketdetails_Id;
	}

	public void setTicketdetails_Id(Integer ticketdetails_Id) {
		this.ticketdetails_Id = ticketdetails_Id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "TicketDetails [ticketdetails_Id=" + ticketdetails_Id + ", type=" + type + ", bus=" + bus + "]";
	}

	public TicketDetails(Integer ticketdetails_Id, String type, Bus bus) {
		super();
		this.ticketdetails_Id = ticketdetails_Id;
		this.type = type;
		this.bus = bus;
	}

	public TicketDetails() {
		super();
	}
	

}
