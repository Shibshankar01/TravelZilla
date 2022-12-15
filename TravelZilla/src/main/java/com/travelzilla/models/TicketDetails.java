package com.travelzilla.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
@Entity
public class TicketDetails {
@Id
@NotBlank(message="ticketId cannot be null")
private int tickedId;
@NotBlank(message="status cannot be null")
private String status;


@ManyToOne
@JoinColumn(name = "bus")
@NotBlank(message="bus_Id cannot be null")
private Bus bus_Id;

public TicketDetails() {
	// TODO Auto-generated constructor stub
}

public TicketDetails(@NotBlank(message = "ticketId cannot be null") int tickedId,
		@NotBlank(message = "status cannot be null") String status,
		@NotBlank(message = "bus_Id cannot be null") Bus bus_Id) {
	super();
	this.tickedId = tickedId;
	this.status = status;
	this.bus_Id = bus_Id;
}

public int getTickedId() {
	return tickedId;
}

public void setTickedId(int tickedId) {
	this.tickedId = tickedId;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Bus getBus_Id() {
	return bus_Id;
}

public void setBus_Id(Bus bus_Id) {
	this.bus_Id = bus_Id;
}

}
