package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.IDiagnosticTestRepository;
import com.cg.hcs.exception.DiagnosticTestException;
import com.cg.hcs.model.DiagnosticTest;

@Service
public class IDiagnosticTestServiceImpl implements IDiagnosticTestService{
	@Autowired
	IDiagnosticTestRepository repo;

	@Override
	public ResponseEntity<List<DiagnosticTest>> getAllTest() throws DiagnosticTestException {
		if(repo.findAll().size()==0) {
			throw new DiagnosticTestException("No tests available");
		}	
		return new ResponseEntity<List<DiagnosticTest>>(repo.findAll(),HttpStatus.OK);	
	}

	@Override
	public ResponseEntity<DiagnosticTest> addNewTest(DiagnosticTest test) throws DiagnosticTestException {
		if (repo.existsById(test.getId())) {
			throw new DiagnosticTestException("Patient with the given Id already Exists");
		} 
		repo.save(test);
		return new ResponseEntity<DiagnosticTest>(test, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<DiagnosticTest>> getTestsOfDiagnosticCenter(int centerid) throws DiagnosticTestException{
		List<DiagnosticTest> testsOfDiagnosticCenter = repo.getTestsOfDiagnosticCenter(centerid);
		if(testsOfDiagnosticCenter.size()==0)
			throw new DiagnosticTestException("Test of the given id not available");
		return new ResponseEntity<List<DiagnosticTest>>(testsOfDiagnosticCenter,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<DiagnosticTest> updateTestDetail(DiagnosticTest test) throws DiagnosticTestException{
		if(repo.existsById(test.getId())) {
			repo.save(test);
			return new ResponseEntity<DiagnosticTest>(test, HttpStatus.OK);
		}
		throw new DiagnosticTestException("Test with th id does not exist");
			
		
	}

	@Override
	public ResponseEntity<DiagnosticTest> removeTestFromDiagnosticCenter(int centerid, DiagnosticTest test)throws DiagnosticTestException {
		// doubt
		if(repo.existsById(test.getId()))
		{	
			if(repo.existsById(test.getId())) {
			repo.findById(test.getId()).get().getDiagnosticCenters().removeIf((c)->c.getId()==centerid);
			return new ResponseEntity<DiagnosticTest>(test, HttpStatus.OK);
			}
			throw new DiagnosticTestException("Test with this id does not exist");
		}
		
		throw new DiagnosticTestException("Center with this id does not exist");
	}

}
