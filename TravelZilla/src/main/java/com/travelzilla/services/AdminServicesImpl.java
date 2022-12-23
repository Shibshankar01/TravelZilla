package com.travelzilla.services;

import java.beans.Encoder;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.models.Admin;
import com.travelzilla.repositories.AdminDAO;

@Service
public class AdminServicesImpl implements AdminServices{

	@Autowired
	private AdminDAO aDao;
	
	private EncryptService encrypt=new EncryptServiceImpl();
	
	@Override
	public Admin addAdmin(Admin admin) throws AdminException {


		if(aDao.findByEmail(admin.getEmail()) != null)
				throw new AdminException("Admin already present with that email id");
        
        	String admin1= encrypt.EncryptPassword(admin.getPassword());
        	admin.setPassword(admin1);
		     return aDao.save(admin);	

	}

	@Override
	public Admin getAdminById(int adminID) throws AdminException {
		// TODO Auto-generated method stub
		return aDao.findById(adminID).orElseThrow(() -> new AdminException("No Admin found with that Id:- "+adminID));
	}

	@Override
	public Admin deleteAdminById(int adminID)throws AdminException{
		// TODO Auto-generated method stub
		Admin admin = aDao.findById(adminID).orElseThrow(() -> new AdminException("No Admin found with that Id:- "+adminID));
		aDao.delete(admin);
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		aDao.findById(admin.getAdminID()).orElseThrow(()-> new AdminException("No Admin found with the Id:-"+admin.getAdminID()));
		return aDao.save(admin);
	}

}
