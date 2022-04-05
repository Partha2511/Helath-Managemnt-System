package com.cg.hcs.service;

import java.util.List;
import com.cg.hcs.model.DiagnosticTest;

public interface ITestService {
	public DiagnosticTest addTest(DiagnosticTest test);
	public DiagnosticTest updateTest(DiagnosticTest test);
	public DiagnosticTest removeTest(DiagnosticTest test);
	public List<DiagnosticTest> viewAllTest(String criteria);
}
