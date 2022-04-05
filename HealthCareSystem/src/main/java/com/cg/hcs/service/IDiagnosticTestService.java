package com.cg.hcs.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.model.DiagnosticTest;

public interface IDiagnosticTestService extends JpaRepository<DiagnosticTest, Integer> {
	public static List<DiagnosticTest> getAllTest(){
		return null;	
	}

	public static DiagnosticTest addNewTest(DiagnosticTest test) {
		return test;
		
	}
	public static List<DiagnosticTest> getTestsOfDiagnosticTest(){
		return null;
		
	}
	public static DiagnosticTest updateTestDetail(DiagnosticTest test) {
		return test;
		
	}
	public static DiagnosticTest removeTestFromDiagnosticCenter(int centerid,DiagnosticTest test) {
		return test;
	

}
}
