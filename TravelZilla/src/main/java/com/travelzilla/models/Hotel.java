package com.travelzilla.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotel_Id;
	@NotNull(message = "Hotel Name Cannot be Null")
	@Size(min = 1, max = 20, message = "Hotel Name Must be Between 1 to 20 Characters")
	private String hotelName;
	
	@NotNull(message = "Hotel Type Cannot be Null")
	private HotelType hotelType;
	
	@Size(min = 10, max = 1000, message = "Hotel Must be Described in 10 to 1000 Charcters" )
	private String hotelDescription;
	
	@Embedded
	@NotNull(message = "Hotel Address cannot be Null")
	private HotelAddress hotelAddress;
	
	@NotNull(message =  "Hotel Rent Cannot be Null")
	@Min(2000)
	private double hotelRent;
	
	@NotNull(message = "Hotel Status Cannot be Null")
	private HotelStatus hotelStatus;

	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Packages> pSet = new HashSet<Packages>();
	
	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel( Integer  hotel_Id, String hotelName, HotelType hotelType, String hotelDescription, HotelAddress hotelAddress,
			double hotelRent, HotelStatus hotelStatus) {
		super();
		this.hotel_Id = hotel_Id;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.hotelAddress = hotelAddress;
		this.hotelRent = hotelRent;
		this.hotelStatus = hotelStatus;
	}

	public Integer getHotel_Id() {
		return hotel_Id;
	}

	public void setHotel_Id( Integer  hotel_Id) {
		this.hotel_Id = hotel_Id;
	}

	public String getHotelName() {
		return hotelName;
	}


	

	

	public Set<Packages> getpSet() {
		return pSet;

	}

	

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public HotelType getHotelType() {
		return hotelType;
	}

	public void setHotelType(HotelType hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public HotelAddress getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(HotelAddress hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public double getHotelRent() {
		return hotelRent;
	}

	public void setHotelRent(double hotelRent) {
		this.hotelRent = hotelRent;
	}

	public HotelStatus getHotelStatus() {
		return hotelStatus;
	}

	public void setHotelStatus(HotelStatus hotelStatus) {
		this.hotelStatus = hotelStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hotelAddress, hotelDescription, hotelName, hotelRent, hotelStatus, hotelType, hotel_Id,
				pSet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(hotelAddress, other.hotelAddress)
				&& Objects.equals(hotelDescription, other.hotelDescription)
				&& Objects.equals(hotelName, other.hotelName)
				&& Double.doubleToLongBits(hotelRent) == Double.doubleToLongBits(other.hotelRent)
				&& hotelStatus == other.hotelStatus && hotelType == other.hotelType
				&& Objects.equals(hotel_Id, other.hotel_Id) && Objects.equals(pSet, other.pSet);
	}

	@Override
	public String toString() {
		return "Hotel [hotel_Id=" + hotel_Id + ", hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ", hotelDescription=" + hotelDescription + ", hotelAddress=" + hotelAddress + ", hotelRent="
				+ hotelRent + ", hotelStatus=" + hotelStatus + "]";
	}

}
