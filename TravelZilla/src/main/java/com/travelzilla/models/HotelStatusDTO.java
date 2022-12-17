package com.travelzilla.models;

public class HotelStatusDTO {

	private Integer hotel_Id;
	private HotelStatus updatedHotelStatus;
	
	public HotelStatusDTO() {
		// TODO Auto-generated constructor stub
	}

	public HotelStatusDTO(Integer hotel_Id, HotelStatus updatedHotelStatus) {
		super();
		this.hotel_Id = hotel_Id;
		this.updatedHotelStatus = updatedHotelStatus;
	}

	public Integer getHotel_Id() {
		return hotel_Id;
	}

	public void setHotel_Id(Integer hotel_Id) {
		this.hotel_Id = hotel_Id;
	}

	public HotelStatus getUpdatedHotelStatus() {
		return updatedHotelStatus;
	}

	public void setUpdatedHotelStatus(HotelStatus updatedHotelStatus) {
		this.updatedHotelStatus = updatedHotelStatus;
	}
	
	
}
