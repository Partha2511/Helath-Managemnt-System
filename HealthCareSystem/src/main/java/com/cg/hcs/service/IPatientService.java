package com.cg.hcs.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;

public interface IPatientService extends JpaRepository<Patient, Integer> {
	public Patient registerPatient(Patient patient);
	public Patient updatePatientDetails(Patient patient);
	public Patient viewPatient(String patientUserName);
	public List<TestResult> getAllTestResult(String patientUserName);
	public TestResult viewTestResult(int TestresultId);
	

}
