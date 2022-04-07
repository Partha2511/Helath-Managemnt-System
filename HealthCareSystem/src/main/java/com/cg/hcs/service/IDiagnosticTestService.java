package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.model.DiagnosticTest;

public interface IDiagnosticTestService{
	public List<DiagnosticTest> getAllTest();
	public DiagnosticTest addNewTest(DiagnosticTest test);
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerid);
	public DiagnosticTest updateTestDetail(DiagnosticTest test);
	public DiagnosticTest removeTestFromDiagnosticCenter(int centerid,DiagnosticTest test);
}
