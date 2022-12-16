package com.travelzilla.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Booking {
@Id
@NotBlank(message="bookingId cannot be null")
private int bookingId;
@NotBlank(message="bookingType cannot be null")
private String bookingType;
@NotBlank(message="description cannot be null")
private String description;
@NotBlank(message="bookingTitle cannot be null")
private String bookingTitle;
@NotBlank(message="bookingDate cannot be null")
private LocalDateTime bookingDate;

@OneToOne
@PrimaryKeyJoinColumn
@NotBlank(message="customerId cannot be null")
private Customer customerId;

@ManyToOne
@JoinColumn(name = "packageId")
@NotBlank(message="packageId cannot be null")
private Packages packageId;

@OneToOne
@PrimaryKeyJoinColumn
@NotBlank
private TicketDetails ticketId;


public Booking() {
	// TODO Auto-generated constructor stub
}
public Booking(@NotBlank(message = "bookingId cannot be null") int bookingId,
		@NotBlank(message = "bookingType cannot be null") String bookingType,
		@NotBlank(message = "description cannot be null") String description,
		@NotBlank(message = "bookingTitle cannot be null") String bookingTitle,
		@NotBlank(message = "bookingDate cannot be null") LocalDateTime bookingDate,
		@NotBlank(message = "customerId cannot be null") Customer customerId,
		@NotBlank(message = "packageId cannot be null") Packages packageId, @NotBlank TicketDetails ticketId) {
	super();
	this.bookingId = bookingId;
	this.bookingType = bookingType;
	this.description = description;
	this.bookingTitle = bookingTitle;
	this.bookingDate = bookingDate;
	this.customerId = customerId;
	this.packageId = packageId;
	this.ticketId = ticketId;
}

public int getBookingId() {
	return bookingId;
}


public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}


public String getBookingType() {
	return bookingType;
}

public void setBookingType(String bookingType) {
	this.bookingType = bookingType;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getBookingTitle() {
	return bookingTitle;
}


public void setBookingTitle(String bookingTitle) {
	this.bookingTitle = bookingTitle;
}

public LocalDateTime getBookingDate() {
	return bookingDate;
}

public void setBookingDate(LocalDateTime bookingDate) {
	this.bookingDate = bookingDate;
}

public Customer getCustomerId() {
	return customerId;
}


public void setCustomerId(Customer customerId) {
	this.customerId = customerId;
}


public Packages getPackageId() {
	return packageId;
}


public void setPackageId(Packages packageId) {
	this.packageId = packageId;
}


public TicketDetails getTicketId() {
	return ticketId;
}


public void setTicketId(TicketDetails ticketId) {
	this.ticketId = ticketId;
}












}
