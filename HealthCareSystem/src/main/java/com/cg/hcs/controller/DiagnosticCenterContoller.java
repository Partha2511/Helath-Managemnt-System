package com.cg.hcs.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.hcs.exception.DiagnosticCenterException;
import com.cg.hcs.exception.ErrorInfo;
import com.cg.hcs.model.DiagnosticCenter;
import com.cg.hcs.service.IDiagnosticCenterServiceImpl;

public class DiagnosticCenterContoller {
	@Autowired
	IDiagnosticCenterServiceImpl impl;
	
	@GetMapping("/getCenters")
	public ResponseEntity<List<DiagnosticCenter>> getAllDiagnosticCenters() throws DiagnosticCenterException{
		return impl.getAllDiagnosticCenters();
	}
	
	@PostMapping("/addCenter")
	public ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter)
			throws DiagnosticCenterException{
		return impl.addDiagnosticCenter(diagnosticCenter);	
	}
	
	@ExceptionHandler(DiagnosticCenterException.class)
	public ResponseEntity<ErrorInfo> handleDiagnosticCenterException(DiagnosticCenterException e, HttpServletRequest req){
		ErrorInfo info=new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.NOT_FOUND);
	}
}
