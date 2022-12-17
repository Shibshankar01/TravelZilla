package com.travelzilla.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Session {

	@Id
	private Integer userId;
	private UserType userType;
	private LocalDateTime timeStamp;
	private String sessionKey;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	@Override
	public String toString() {
		return "Session [userId=" + userId + ", userType=" + userType + ", timeStamp=" + timeStamp + ", sessionKey="
				+ sessionKey + "]";
	}
	
	
	
	
}
