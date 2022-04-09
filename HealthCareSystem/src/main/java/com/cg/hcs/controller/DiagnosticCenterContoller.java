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
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.exception.DiagnosticCenterException;
import com.cg.hcs.exception.ErrorInfo;
import com.cg.hcs.model.Appointment;
import com.cg.hcs.model.DiagnosticCenter;
import com.cg.hcs.model.DiagnosticTest;
import com.cg.hcs.service.IDiagnosticCenterServiceImpl;

@RestController
public class DiagnosticCenterContoller {
	@Autowired
	IDiagnosticCenterServiceImpl impl;

	@GetMapping("/getCenters")
	public ResponseEntity<List<DiagnosticCenter>> getAllDiagnosticCenters() throws DiagnosticCenterException {
		return impl.getAllDiagnosticCenters();
	}

	@PostMapping("/addCenter")
	public ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter)
			throws DiagnosticCenterException {
		return impl.addDiagnosticCenter(diagnosticCenter);
	}

	@GetMapping("/getCenter/{id}")
	public ResponseEntity<DiagnosticCenter> getDiagnosticCenterById(@PathVariable("id") int diagnosticCenterId)
			throws DiagnosticCenterException {
		return impl.getDiagnosticCenterById(diagnosticCenterId);
	}

	@PutMapping("/modifyCenter")
	public ResponseEntity<DiagnosticCenter> updateDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter)
			throws DiagnosticCenterException {
		return impl.updateDiagnosticCenter(diagnosticCenter);
	}

	@GetMapping("/testDetail/{id}/{name}")
	public ResponseEntity<DiagnosticTest> viewTestDetails(@PathVariable("id") int diagnosticCenterId,
			@PathVariable("name") String testName) throws DiagnosticCenterException {
		return impl.viewTestDetails(diagnosticCenterId, testName);
	}

	@PostMapping("/addTest/{id}")
	public ResponseEntity<DiagnosticTest> addTest(@PathVariable("id") int diagnosticCenterId,
			@RequestBody DiagnosticTest test) throws DiagnosticCenterException {
		return impl.addTest(diagnosticCenterId, test);
	}

	@GetMapping("/getCenterByName/{name}")
	public ResponseEntity<DiagnosticCenter> getDiagnosticCenter(@PathVariable("name") String centerName)
			throws DiagnosticCenterException {
		return impl.getDiagnosticCenter(centerName);
	}

	@DeleteMapping("/removeCenter/{id}")
	public ResponseEntity<DiagnosticCenter> removeDiagnosticCenter(@PathVariable("id") int id)
			throws DiagnosticCenterException {
		return impl.removeDiagnosticCenter(id);
	}

	@GetMapping("/getAppointmentsByCenter/{name}")
	public ResponseEntity<List<Appointment>> getListOfAppointments(@PathVariable("name") String centerName)
			throws DiagnosticCenterException {
		return impl.getListOfAppointments(centerName);
	}

	@ExceptionHandler(DiagnosticCenterException.class)
	public ResponseEntity<ErrorInfo> handleDiagnosticCenterException(DiagnosticCenterException e,
			HttpServletRequest req) {
		ErrorInfo info = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.NOT_FOUND);
	}
}
