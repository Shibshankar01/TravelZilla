package com.travelzilla.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Report;

@Repository
public interface ReportDAO extends JpaRepository<Report, Integer>{

}
