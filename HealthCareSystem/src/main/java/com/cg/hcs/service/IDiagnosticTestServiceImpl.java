package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.IDiagnosticTestRepository;
import com.cg.hcs.model.DiagnosticTest;
@Service
public class IDiagnosticTestServiceImpl implements IDiagnosticTestService{
	@Autowired
	IDiagnosticTestRepository repo;

	@Override
	public List<DiagnosticTest> getAllTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test) {
		repo.save(test);
		return test;
	}

	@Override
	public List<DiagnosticTest> getTestsOfDiagnosticTest() {
		// TODO Auto-generated method stub
		return repo.getTestsOfDiagnosticTest();
	}

	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test) {
		// TODO Auto-generated method stub
		if(repo.existsById(test.getId())) {
			repo.save(test);
			return test;
		}
		return null;
			
		
	}

	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerid, DiagnosticTest test) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
