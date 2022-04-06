package com.cg.hcs.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hcs.model.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	@Query("select a from appointment_tbl a join a.patient p where p.name=?1")
	public Set<Appointment> viewAppointments(String patientName);
	
	//doubt
	@Query("Select a from appointment_tbl a join a.diagnosticTests t "
			+ "join a.diagnosticCenter c "
			+ "where c.id=?1 and t.testName=?2 a.approvalStatus=?3")
	public List<Appointment> getAppointmentList(int centerId,String test,int status);
}

