package com.travelzilla.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;




import javax.persistence.*;


@Entity
public class Travels {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelId;
	
	private String travelName;
	private String agentName;
	
	@Embedded
	private HotelAddress address;
	private String contact;
	
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "travel")
	private Set<Bus> busList= new HashSet<>();


	public Travels() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Travels(Integer travelId, String travelName, String agentName, HotelAddress address, String contact,
			Set<Bus> busList) {
		super();
		this.travelId = travelId;
		this.travelName = travelName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
		this.busList = busList;
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


	public HotelAddress getAddress() {
		return address;
	}


	public void setAddress(HotelAddress address) {
		this.address = address;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public Set<Bus> getBusList() {
		return busList;
	}


	public void setBusList(Set<Bus> busList) {
		this.busList = busList;
	}


	@Override
	public int hashCode() {
		return Objects.hash(address, agentName, contact, travelId, travelName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travels other = (Travels) obj;
		return Objects.equals(address, other.address) && Objects.equals(agentName, other.agentName)
				&& Objects.equals(contact, other.contact) && Objects.equals(travelId, other.travelId)
				&& Objects.equals(travelName, other.travelName);
	}

	
	
	
	
	
	

}
