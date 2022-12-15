package com.travelzilla.Exception;

import java.time.LocalDateTime;

public class MyError {
	
	
	private LocalDateTime TimeStamp;
	private String Message;
	private String Desc;
	public MyError(LocalDateTime timeStamp, String message, String desc) {
		super();
		TimeStamp = timeStamp;
		Message = message;
		Desc = desc;
	}
	public MyError() {
		super();
	}
	public LocalDateTime getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		TimeStamp = timeStamp;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	@Override
	public String toString() {
		return "MyError [TimeStamp=" + TimeStamp + ", Message=" + Message + ", Desc=" + Desc + "]";
	}

}
