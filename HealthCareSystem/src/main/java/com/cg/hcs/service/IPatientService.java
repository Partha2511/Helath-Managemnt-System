package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;

public interface IPatientService{
	public Patient registerPatient(Patient patient);
	public Patient updatePatientDetails(Patient patient);
	public Patient viewPatient(String patientUserName);
	public List<TestResult> getAllTestResult(String patientUserName);
	public TestResult viewTestResult(int TestresultId);
	

}
