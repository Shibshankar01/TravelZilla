package com.travelzilla.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.hibernate.boot.model.relational.SimpleAuxiliaryDatabaseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.exceptions.LoginException;
import com.travelzilla.models.Admin;
import com.travelzilla.models.Customer;
import com.travelzilla.models.LoginDTO;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.repositories.AdminDAO;
import com.travelzilla.repositories.CustomerDAO;
import com.travelzilla.repositories.SessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServicesImpl implements LoginServices{

	@Autowired
	private SessionDAO sDao;
	
	@Autowired
	private AdminDAO aDao;
	
	@Autowired
	private CustomerDAO cDao;
	
	private EncryptService decrypt=new EncryptServiceImpl();
	
	@Override
	public Session login(LoginDTO loginDto) throws LoginException {
		// TODO Auto-generated method stub
		
		
		Session mainSession = null;
		if(loginDto.getUserType()==UserType.ADMIN) {
			Admin admin =  aDao.findByEmail(loginDto.getEmail());
		
//			Admin admin1= decrypt.DecryptPassword(admin);
			
			Admin Demo=new Admin();
			Demo.setPassword(loginDto.getPassword());
			Admin admin2= decrypt.EncryptPassword(Demo);
			
			System.out.println("ajay--"+admin2.getPassword());
			if(admin == null)
				throw new LoginException("Admin not present with that email");
			
			Optional<Session> currentSession =  sDao.findById(admin.getAdminID());
			
			if(currentSession.isPresent())
				throw new LoginException("This user is already logged in");
			
			
			
			if(admin.getPassword().equals(admin2.getPassword())) {
				String key = RandomString.make(6);
				
				Session session = new Session();
				session.setSessionKey(key);
				session.setUserId(admin.getAdminID());
				session.setUserType(loginDto.getUserType());
				session.setTimeStamp(LocalDateTime.now());
				mainSession =  sDao.save(session);	
			}
			else
				throw new LoginException("Please enter the correct password");
		}
		else {
			Customer customer = cDao.findByEmail(loginDto.getEmail());
			if(customer == null)
				throw new LoginException("Customer not present with the email:-"+loginDto.getEmail());
			
			Optional<Session> currentSession = sDao.findById(customer.getCustomerId());
			
			if(currentSession.isPresent())
				throw new LoginException("This user is already logged in");
		
			if(customer.getCustomerPassword().equals(loginDto.getPassword())) {
				String key = RandomString.make(6);
				
				Session session = new Session();
				session.setSessionKey(key);
				session.setUserId(customer.getCustomerId());
				session.setUserType(loginDto.getUserType());
				session.setTimeStamp(LocalDateTime.now());
				mainSession = sDao.save(session);;
			}
			else {
				throw new LoginException("Please enter the correct password");
			}
		}
		return mainSession;
	}

	@Override
	public String logout(Integer userId, UserType userType) throws LoginException {
		// TODO Auto-generated method stub
		Session session = sDao.findByUserIdAndUserType(userId, userType);
		
		if(session == null)
			throw new LoginException("No user logged in with that User Id and Type");
		
		sDao.delete(session);
		
		return "Logged Out successfully!";
	}

}
