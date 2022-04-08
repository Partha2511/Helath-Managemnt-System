package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.IDiagnosticTestRepository;
import com.cg.hcs.exception.DiagnosticTestException;
import com.cg.hcs.model.DiagnosticTest;
@Service
public class IDiagnosticTestServiceImpl implements IDiagnosticTestService{
	@Autowired
	IDiagnosticTestRepository repo;

	@Override
	public List<DiagnosticTest> getAllTest() throws DiagnosticTestException {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test) throws DiagnosticTestException {
		repo.save(test);
		return test;
	}

	@Override
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerid) throws DiagnosticTestException{
		// TODO Auto-generated method stub
		return repo.getTestsOfDiagnosticCenter(centerid);
	}

	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test) throws DiagnosticTestException{
		// TODO Auto-generated method stub
		if(repo.existsById(test.getId())) {
			repo.save(test);
			return test;
		}
		return null;
			
		
	}

	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerid, DiagnosticTest test)throws DiagnosticTestException {
		// TODO Auto-generated method stub
		if(repo.existsById(test.getId()))
		{
			repo.findById(test.getId()).get().getDiagnosticCenters().removeIf((c)->c.getId()==centerid);
			return test;
		}
		
		return null;
	}

}
