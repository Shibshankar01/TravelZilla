package com.travelzilla.services;

import com.travelzilla.exceptions.LoginException;
import com.travelzilla.models.LoginDTO;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;

public interface LoginServices {

	public Session login(LoginDTO loginDto) throws LoginException;
	
	public String logout(Integer userId, UserType userType)throws LoginException;
}
