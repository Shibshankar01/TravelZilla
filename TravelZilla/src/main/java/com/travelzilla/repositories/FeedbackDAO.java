package com.travelzilla.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.travelzilla.models.Feedback;
import com.travelzilla.models.Packages;

@Repository
public interface FeedbackDAO extends JpaRepository<Feedback,Integer>{
	
	public List<Feedback> findByPackages(Packages packages);
	
	
}
