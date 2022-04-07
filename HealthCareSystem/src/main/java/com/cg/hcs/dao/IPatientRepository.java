package com.cg.hcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hcs.model.Patient;
import com.cg.hcs.model.TestResult;
@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
	@Query("select t from testresult_tbl t join t.appointment_tbl a where a.id=t.id  ")
	public List<TestResult> getAllTestResult(String patientUserName);

}
