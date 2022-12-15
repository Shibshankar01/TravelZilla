package com.travelzilla.services;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.models.Admin;

public interface AdminServices {
	
	public Admin addAdmin(Admin admin);
	
	public Admin getAdminById(int adminID)throws AdminException;
	
	public Admin deleteAdminById(int adminID)throws AdminException;

}
