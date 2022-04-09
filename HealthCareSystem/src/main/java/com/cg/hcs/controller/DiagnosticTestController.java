package com.cg.hcs.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.hcs.exception.DiagnosticTestException;
import com.cg.hcs.exception.ErrorInfo;
import com.cg.hcs.model.DiagnosticTest;
import com.cg.hcs.service.IDiagnosticTestServiceImpl;

public class DiagnosticTestController {
	@Autowired
	IDiagnosticTestServiceImpl impl;
	
	@GetMapping("/getAllTests")
	public ResponseEntity<List<DiagnosticTest>> getAllTest() throws DiagnosticTestException{
		return impl.getAllTest();
	}
	
	@PostMapping("/addTests")
	public ResponseEntity<DiagnosticTest> addNewTest(@RequestBody DiagnosticTest test) throws DiagnosticTestException{
		return impl.addNewTest(test);	
	}
	
	@GetMapping("/getTests/{id}")
	public ResponseEntity<List<DiagnosticTest>> getTestsOfDiagnosticCenter(@PathVariable("id") int centerid) throws DiagnosticTestException{
		return impl.getTestsOfDiagnosticCenter(centerid);
	
	}
	
	@PutMapping("/updateTests")
	public ResponseEntity<DiagnosticTest> updateTestDetail(@RequestBody DiagnosticTest test) throws DiagnosticTestException{
		return impl.updateTestDetail(test);
	
	}
	@DeleteMapping("/removeTest/{id}")
	public ResponseEntity<DiagnosticTest> removeTestFromDiagnosticCenter(@PathVariable("id") int centerid, @RequestBody DiagnosticTest test)throws DiagnosticTestException{
		return impl.removeTestFromDiagnosticCenter(centerid, test);
	
	}
	
	
	@ExceptionHandler(DiagnosticTestException.class)
	public ResponseEntity<ErrorInfo> handleDiagnosticTestException(DiagnosticTestException e, HttpServletRequest req){
		ErrorInfo info=new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.NOT_FOUND);
	}

}
