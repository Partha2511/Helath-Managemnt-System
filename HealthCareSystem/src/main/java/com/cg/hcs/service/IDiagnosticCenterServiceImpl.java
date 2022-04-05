package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.IDiagnosticCenterRepository;
import com.cg.hcs.model.Appointment;
import com.cg.hcs.model.DiagnosticCenter;
import com.cg.hcs.model.DiagnosticTest;

@Service
public class IDiagnosticCenterServiceImpl implements IDiagnosticCenterService {
	@Autowired
	IDiagnosticCenterRepository repo;
	
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		// TODO Auto-generated method stub
		repo.save(diagnosticCenter);
		return diagnosticCenter;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		return repo.viewTestDetails(diagnosticCenterId, testName);
	}

	@Override
	public DiagnosticTest addTest(int diagnosticCenterId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getListOfAppointments(String centerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
