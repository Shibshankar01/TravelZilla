package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

}
