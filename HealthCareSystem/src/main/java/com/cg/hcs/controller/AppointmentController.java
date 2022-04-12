package com.cg.hcs.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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

import com.cg.hcs.exception.AppointmentException;
import com.cg.hcs.exception.ErrorInfo;
import com.cg.hcs.model.Appointment;
import com.cg.hcs.service.IAppointmentServiceImpl;

@RestController
public class AppointmentController {
	@Autowired
	IAppointmentServiceImpl impl;
	
	@PostMapping("/addAppointment")
	public ResponseEntity<Appointment>  addAppointment(@RequestBody Appointment appointment) throws AppointmentException{
		return impl.addAppointment(appointment);
	}
	
	@GetMapping("/viewAppointmentsByname/{name}")
	public ResponseEntity<Set<Appointment>> viewAppointments(@PathVariable("name") String patientName) throws AppointmentException{
		return impl.viewAppointments(patientName);
	}
	
	@GetMapping("/viewAppointment/{id}")
	public ResponseEntity<Appointment> viewAppointment(@PathVariable("id") int appointmentId) throws AppointmentException{
		return impl.viewAppointment(appointmentId);
	}
	
	@PutMapping("/updateAppointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) throws AppointmentException{
		return impl.updateAppointment(appointment);
	}
	
	@GetMapping("/getAppointments/{id}/{test}/{status}")
	public ResponseEntity<List<Appointment>> getAppointmentList(@PathVariable("id") int centerId, @PathVariable("test") String test, 
			@PathVariable("status") String status) throws AppointmentException{
		return impl.getAppointmentList(centerId, test, status);
	}
	
	@DeleteMapping("/removeAppointment")
	public ResponseEntity<Appointment> removeAppointment(@RequestBody Appointment appointment) throws AppointmentException{
		return impl.removeAppointment(appointment);
	}
	
	@ExceptionHandler(AppointmentException.class)
	public ResponseEntity<ErrorInfo> handleTestResultException(AppointmentException e, HttpServletRequest req){
		ErrorInfo info=new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.NOT_FOUND);
	}
}
