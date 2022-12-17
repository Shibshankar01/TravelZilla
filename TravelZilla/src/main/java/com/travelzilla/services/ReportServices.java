package com.travelzilla.services;

import java.util.*;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.ReportException;
import com.travelzilla.models.Report;
import com.travelzilla.models.ReportDTO;


public interface ReportServices {
	
	public Report addAReport(ReportDTO report) throws AdminException;
	
	public Report deleteAReportById(Integer reportID)throws ReportException;

}
