package com.travelzilla.services;


import com.travelzilla.models.Admin;

public interface EncryptService {
	
	
	public Admin DecryptPassword(Admin admin);
	
	public Admin EncryptPassword(Admin admin);

}
