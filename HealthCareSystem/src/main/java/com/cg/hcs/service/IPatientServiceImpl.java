package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.IDiagnosticTestRepository;
import com.cg.hcs.dao.IPatientRepository;
import com.cg.hcs.exception.AppointmentException;
import com.cg.hcs.exception.DiagnosticCenterException;
import com.cg.hcs.exception.PatientException;
import com.cg.hcs.model.Appointment;
import com.cg.hcs.model.DiagnosticCenter;
import com.cg.hcs.model.DiagnosticTest;
import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;
@Service
public class IPatientServiceImpl implements IPatientService{
	@Autowired
	IPatientRepository repo;

	@Override
	public ResponseEntity<Patient> registerPatient(Patient patient) throws PatientException {
		if (repo.existsById(patient.getPatientid())) {
			throw new PatientException("Patient with the given Id already Exists");
		}
		repo.save(patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Patient> updatePatientDetails(Patient patient) throws PatientException {
		if (repo.existsById(patient.getPatientid())) {
			repo.save(patient);
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}
		throw new PatientException("Patient with the given Id doesn't Exists");
		
	}

	@Override
	public ResponseEntity<Patient> viewPatient(String patientUserName) throws PatientException {
		Patient pat=new Patient();
		if (repo.existsById(pat.getPatientid())) {
			repo.save(pat);
			return new ResponseEntity<Patient>(pat, HttpStatus.OK);
		}
		throw new PatientException("Patient with the given Id doesn't Exists");
		
		
	}

	@Override
	public ResponseEntity<ResponseEntity<Patient>> getAllTestResult(String patientUserName) throws PatientException {
		// TODO Auto-generated method stub
		if (repo.findAll().size() == 0) {
			throw new PatientException("No Patient is available");
		}
		return new ResponseEntity<ResponseEntity<Patient>>((ResponseEntity<Patient>) repo.findAll(), HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<TestResult> viewTestResult(int TestresultId) throws PatientException {
		if (repo.existsById(TestresultId)) {
			throw new PatientException("Patient with the given Id doesn't Exists");
		}
		TestResult test = repo.viewTestResult(TestresultId);
		if (test == null) {
			throw new PatientException("Test with the given name doesn't Exists");
		}
		return new ResponseEntity<TestResult>(test, HttpStatus.OK);
		
	}
	
	

}
