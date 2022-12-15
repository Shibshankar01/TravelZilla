package com.travelzilla.services;

import java.util.*;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.ReportException;
import com.travelzilla.models.Report;


public interface ReportServices {
	
	public Report addAReport(Report report);
	
	public List<Report> getAllReportsByAdminID(int adminId)throws AdminException;
	
	public Report deleteAReportById(Integer reportID)throws ReportException;

}
