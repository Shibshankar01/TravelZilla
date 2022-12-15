package com.travelzilla.models;

import java.util.Objects;

public class HotelAddress {

	private String state;
	private String city;
	private String landmark;
	private String pin;

	public HotelAddress() {
		// TODO Auto-generated constructor stub
	}

	public HotelAddress(String state, String city, String landmark, String pin) {
		super();
		this.state = state;
		this.city = city;
		this.landmark = landmark;
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, landmark, pin, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelAddress other = (HotelAddress) obj;
		return Objects.equals(city, other.city) && Objects.equals(landmark, other.landmark)
				&& Objects.equals(pin, other.pin) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", landmark=" + landmark + ", pin=" + pin + "]";
	}

}
