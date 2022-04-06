package com.cg.hcs.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dao.IAppointmentRepository;
import com.cg.hcs.model.Appointment;

@Service
public class IAppointmentServiceImpl implements IAppointmentService {
	@Autowired
	IAppointmentRepository repo;
	
	@Override
	public Appointment addAppointment(Appointment appointment) {
		repo.save(appointment);
		return appointment;
	}

	@Override
	public Set<Appointment> viewAppointments(String patientName) {
		return repo.viewAppointments(patientName);
	}

	@Override
	public Appointment viewAppointment(int appointmentId) {
		if(repo.existsById(appointmentId)) {
			return repo.findById(appointmentId).get();
		}
		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		if(repo.existsById(appointment.getId())) {
			repo.save(appointment);
			return appointment;
		}
		return null;
	}

	@Override
	public List<Appointment> getAppointmentList(int centerId, String test, int status) {
		return repo.getAppointmentList(centerId, test, status);
	}

	@Override
	public Appointment removeAppointment(Appointment appointment) {
		if(repo.existsById(appointment.getId())) {
			repo.deleteById(appointment.getId());
			return appointment;
		}
		return null;
	}

}
