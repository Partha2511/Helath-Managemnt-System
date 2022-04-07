package com.cg.hcs.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.hcs.dao.ITestResultRepository;
import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;

@Service
public class ITestResultServiceImpl implements ITestResultService {
	@Autowired
	ITestResultRepository repo;
	@Override
	public TestResult addTestResult(TestResult tr) {
		repo.save(tr);
		return tr;
	}
	
	@Override
	public TestResult updateResult(TestResult tr) {
		if(repo.existsById(tr.getId())) {
			repo.save(tr);
			return tr;
		}
		return null;
	}
	
	@Override
	public TestResult removeTestResult(int id) {
		if(repo.existsById(id)) {
			TestResult tr = repo.findById(id).get();
			repo.deleteById(tr.getId());
			return tr;
		}
		return null;
	}
	
	@Override
	public Set<TestResult> viewResultsByPatient(Patient patient){
		return repo.viewResultsByPatient(patient);
	}
}