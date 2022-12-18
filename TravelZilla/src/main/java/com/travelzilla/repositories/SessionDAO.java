package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;

@Repository
public interface SessionDAO extends JpaRepository<Session, Integer>{

	public Session findByUserIdAndUserType(Integer userId, UserType userType);
	
	public Session findBySessionKey(String sessionKey);
}
