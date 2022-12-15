package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.ReportException;
import com.travelzilla.models.Admin;
import com.travelzilla.models.Report;
import com.travelzilla.repositories.AdminDAO;
import com.travelzilla.repositories.ReportDAO;

public class ReportServicesImpl implements ReportServices{

	private ReportDAO rDao;
	
	private AdminDAO aDao;
	
	@Override
	public Report addAReport(Report report) {
		// TODO Auto-generated method stub
		return rDao.save(report);
	}

	@Override
	public List<Report> getAllReportsByAdminID(int adminId) throws AdminException {
		// TODO Auto-generated method stub
		Admin admin = aDao.findById(adminId).orElseThrow(()-> new AdminException("No Admin found with the Id:- "+adminId));
		return admin.getReports();
	}

	@Override
	public Report deleteAReportById(Integer reportID) throws ReportException {
		// TODO Auto-generated method stub
		Report report = rDao.findById(reportID).orElseThrow(()-> new ReportException("No Report found with that exception"));
		rDao.delete(report);
		return report;
	}

}
