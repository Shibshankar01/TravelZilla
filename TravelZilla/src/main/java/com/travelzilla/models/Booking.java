package com.travelzilla.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.sym.Name;

@Entity
public class Booking {
	@Id
	@NotBlank(message = "bookingId cannot be null")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@NotBlank(message = "description cannot be null")
	private String description;
	@NotBlank(message = "bookingTitle cannot be null")
	private String bookingTitle;
	@NotBlank(message = "bookingDate cannot be null")
	private LocalDateTime bookingDate;

	private Double totalCost;


	private BookingStatus bookingStatus = BookingStatus.PAYMENT_PENDING;
	
	@NotNull(message = "Number Of Person Cannot Be Null")
	@Min(value = 1, message = "Number Of Person Should Be Atleast 1")
	private Integer noOfPersons;	


	@ManyToOne
	@JoinColumn(name = "customerId" )
	@NotBlank(message = "customer cannot be null")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "packageId")
	@NotNull(message = "package cannot be null")
	private Packages packages;

	@OneToOne
	@PrimaryKeyJoinColumn
	@NotBlank
	private TicketDetails ticket;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(@NotBlank(message = "bookingId cannot be null") int bookingId,
			@NotBlank(message = "description cannot be null") String description,
			@NotBlank(message = "bookingTitle cannot be null") String bookingTitle,
			@NotBlank(message = "bookingDate cannot be null") LocalDateTime bookingDate,
			@NotBlank(message = "customerId cannot be null") Customer customerId,
			@NotBlank(message = "packages cannot be null") Packages packages, @NotBlank TicketDetails ticketId) {
		super();
		this.bookingId = bookingId;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
		this.customer = customerId;
		this.packages = packages;
		this.ticket = ticketId;
	}
	
	
	
	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customerId) {
		this.customer = customerId;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public TicketDetails getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetails ticket) {
		this.ticket = ticket;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
