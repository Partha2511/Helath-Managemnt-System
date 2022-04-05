package com.cg.hcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hcs.model.DiagnosticCenter;
import com.cg.hcs.model.DiagnosticTest;

@Repository
public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer> {
	@Query("select t from DiagnosticCenter c join c.tests t where c.id=?1 and t.testName=?2")
	public DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
}
