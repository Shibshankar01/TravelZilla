package com.travelzilla.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Travels {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer travelId;
	private String travelName;
	private String agentName;
	private String address;
	private String contact;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "travel")
	private List<Bus> bus;

	public Travels(Integer travelId, String travelName, String agentName, String address, String contact,
			List<Bus> bus) {
		super();
		this.travelId = travelId;
		this.travelName = travelName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
		this.bus = bus;
	}

	public Travels() {
		super();
	}

	public Integer getTravelId() {
		return travelId;
	}

	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
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

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Travels [travelId=" + travelId + ", travelName=" + travelName + ", agentName=" + agentName
				+ ", address=" + address + ", contact=" + contact + ", bus=" + bus + "]";
	}
	
	
	
	
	

}
