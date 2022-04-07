package com.cg.hcs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.hcs.model.DiagnosticTest;
@Repository
public interface IDiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer> {
	@Query("")
	public List<DiagnosticTest> getAllTest();
	@Query("")
	public List<DiagnosticTest> getTestsOfDiagnosticTest();

}
