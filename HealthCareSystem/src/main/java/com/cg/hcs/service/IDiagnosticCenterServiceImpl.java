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
		return repo.findAll();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		repo.save(diagnosticCenter);
		return diagnosticCenter;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		if (repo.existsById(diagnosticCenterId)) {
			return repo.findById(diagnosticCenterId).get();
		}
		return null;
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		if(repo.existsById(diagnosticCenter.getId())) {
			repo.save(diagnosticCenter);
		}
		return null;
	}

	@Override
	public DiagnosticTest viewTestDetails(int diagnosticCenterId, String testName) {
		return repo.viewTestDetails(diagnosticCenterId, testName);
	}

	@Override//doubt
	public DiagnosticTest addTest(int diagnosticCenterId, int testId) {
//		if(repo.find)
		return null;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerName) {
		return repo.getDiagnosticCenter(centerName);
	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) {
		if(repo.existsById(id)) {
			DiagnosticCenter center=repo.findById(id).get();
			repo.deleteById(id);
			return center;
		}
		return null;
	}

	@Override
	public List<Appointment> getListOfAppointments(String centerName) {
		return repo.getListOfAppointments(centerName);
	}

}
