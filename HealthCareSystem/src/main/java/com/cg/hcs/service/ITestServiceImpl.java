package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.hcs.dao.ITestRepository;
import com.cg.hcs.model.DiagnosticTest;

@Service
public class ITestServiceImpl implements ITestService{
	@Autowired
	ITestRepository repo;
	
	@Autowired
	public DiagnosticTest addTest(DiagnosticTest test) {
		repo.save(test);
		return test;
	}
	
	@Autowired
	public DiagnosticTest updateTest(DiagnosticTest test) {
		if(repo.existsById(test.getId())) {
			repo.save(test);
			return test;
		}
		return null;
	}
	
	@Autowired
	public DiagnosticTest removeTest(DiagnosticTest test) {
		if(repo.existsById(test.getId())) {
			repo.deleteById(test.getId());
			return test;
		}
		return null;
	}
	
	@Autowired
	public List<DiagnosticTest> viewAllTest(String criteria){
		return repo.viewAllTest(criteria);
	}

}
