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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.hcs.exception.ErrorInfo;
import com.cg.hcs.exception.TestException;

import com.cg.hcs.model.DiagnosticTest;
import com.cg.hcs.service.ITestServiceImpl;

public class TestController {
	@Autowired
	ITestServiceImpl impl;
	
	@PostMapping("/addTest")
	public  ResponseEntity<DiagnosticTest> addTest(@RequestBody DiagnosticTest test) throws TestException{
		return impl.addTest(test);
	}
	
	@PutMapping("/updateTest")
	public ResponseEntity<DiagnosticTest> updateTest(@RequestBody DiagnosticTest test) throws TestException{
		return impl.updateTest(test);
	}
	
	@DeleteMapping("/removeTest")
	public ResponseEntity<DiagnosticTest> removeTest(@RequestBody DiagnosticTest test) throws TestException {
		return impl.removeTest(test);
	}
	
	@GetMapping("/viewAllTest")
	public ResponseEntity<List<DiagnosticTest>> viewAllTest(@RequestBody String criteria) throws TestException{
		return impl.viewAllTest(criteria);
	}
	@ExceptionHandler(TestException.class)
	public ResponseEntity<ErrorInfo> handleTestException(TestException e, HttpServletRequest req){
		ErrorInfo info=new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.NOT_FOUND);
	}
}
