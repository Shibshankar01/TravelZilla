package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Feedback;

@Repository
public interface FeedbackDAO extends JpaRepository<Feedback,Integer>{

}
