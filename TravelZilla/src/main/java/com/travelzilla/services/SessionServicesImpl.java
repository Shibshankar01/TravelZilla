package com.travelzilla.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Session;
import com.travelzilla.repositories.SessionDAO;

@Service
public class SessionServicesImpl implements SessionServices{

	@Autowired
	private SessionDAO sDao;
	
	@Override
	public Session getASessionByKey(String key) throws SessionException {
		// TODO Auto-generated method stub
		Session currentSession = sDao.findBySessionKey(key);
		if(currentSession==null)
			throw new SessionException("No session found with that session key");
		return currentSession;
	}

	
}
