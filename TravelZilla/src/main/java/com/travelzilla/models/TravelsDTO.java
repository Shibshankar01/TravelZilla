package com.travelzilla.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TravelsDTO {

    
	
	private String travelName;

	private String agentName;
	
	private String address;

	private String contact;
	
	private Integer Bus_id;

	public TravelsDTO(String travelName, String agentName, String address, String contact, Integer bus_id) {
		super();
		this.travelName = travelName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
		this.Bus_id = bus_id;
	}

	public TravelsDTO() {
		super();
	}

	public String getTravelName() {
		return travelName;
	}

	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getBus_id() {
		return Bus_id;
	}

	public void setBus_id(Integer bus_id) {
		this.Bus_id = bus_id;
	}

	@Override
	public String toString() {
		return "TravelsDTO [travelName=" + travelName + ", agentName=" + agentName + ", address=" + address
				+ ", contact=" + contact + ", Bus_id=" + Bus_id + "]";
	}
	
	
	
	
}
