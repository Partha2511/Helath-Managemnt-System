package com.cg.hcs.service;

import java.util.Set;

import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;

public interface ITestResultService {
	public TestResult addTestResult(TestResult tr);
	public TestResult updateResult(TestResult tr);
	public TestResult removeTestResult(int id);
	public Set<TestResult> viewResultsByPatient(Patient patient);
}
