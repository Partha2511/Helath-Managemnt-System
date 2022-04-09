package com.cg.hcs.controller;

import java.time.LocalDateTime;
import java.util.Set;

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
import com.cg.hcs.exception.TestResultException;
import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;
import com.cg.hcs.service.ITestResultServiceImpl;

public class TestResultController {
	@Autowired
	ITestResultServiceImpl impl;
	
	@PostMapping("/addTestResult")
	public ResponseEntity<TestResult> addTestResult(@RequestBody TestResult tr) throws TestResultException {
		return impl.addTestResult(tr);
	}
	
	@PutMapping("/updateResult")
	public ResponseEntity<TestResult> updateResult(@RequestBody TestResult tr) throws TestResultException{
		return impl.updateResult(tr);
	}
	
	@DeleteMapping("/removeTestResult")
	public ResponseEntity<TestResult> removeTestResult(@RequestBody int id) throws TestResultException{
		return impl.removeTestResult(id);
	}
	
	@GetMapping("/viewResultsByPatient")
	public ResponseEntity<Set<TestResult>> viewResultsByPatient(@RequestBody Patient patient) throws TestResultException{
		return impl.viewResultsByPatient(patient);
	}
	
	@ExceptionHandler(TestResultException.class)
	public ResponseEntity<ErrorInfo> handleTestResultException(TestResultException e, HttpServletRequest req){
		ErrorInfo info=new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.NOT_FOUND);
	}
}
