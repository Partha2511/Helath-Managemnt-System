package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.IDiagnosticTestRepository;
import com.cg.hcs.dao.IPatientRepository;
import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;
@Service
public class IPatientServiceImpl implements IPatientService{
	@Autowired
	IPatientRepository repo;
	@Override
	public Patient registerPatient(Patient patient) {
		// TODO Auto-generated method stub
		repo.save(patient);
		return patient;
		
		
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		// TODO Auto-generated method stub
		if(repo.existsById(patient.getPatientid())) {
			repo.save(patient);
			return patient;
		}
		return null;
	}

	@Override
	public Patient viewPatient(String patientUserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestResult> getAllTestResult(String patientUserName) {
		// TODO Auto-generated method stub
		return repo.getAllTestResult(patientUserName);
		
	}

	@Override
	public TestResult viewTestResult(int TestresultId) {
		// TODO Auto-generated method stub
		return null;
	}

}
