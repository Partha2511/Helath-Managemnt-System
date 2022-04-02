package com.cg.hcs;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_tbl")
public class Appointment {
	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "AppointmentDate")
	private LocalDate appointmentDate;
	
	public Appointment() {
		super();
	}
	public Appointment(int id, LocalDate appointmentDate) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	
	
	

}
