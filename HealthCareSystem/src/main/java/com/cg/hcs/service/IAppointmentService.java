package com.cg.hcs.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.cg.hcs.exception.AppointmentException;
import com.cg.hcs.model.Appointment;


public interface IAppointmentService {
	public ResponseEntity<Appointment> addAppointment(Appointment appointment)throws AppointmentException;
	public Set<Appointment> viewAppointments(String patientName);
	public Appointment viewAppointment(int appointmentId);
	public Appointment updateAppointment(Appointment appointment);
	public List<Appointment> getAppointmentList(int centerId,String test,String status);
	public Appointment removeAppointment(Appointment appointment);
}
