package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.model.Appointment;
import com.cg.hcs.model.DiagnosticCenter;
import com.cg.hcs.model.DiagnosticTest;

public interface IDiagnosticCenterService {
	public List<DiagnosticCenter> getAllDiagnosticCenters();	
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId);
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public DiagnosticTest viewTestDetails(int diagnosticCenterId,String testName);
	public DiagnosticTest addTest(int diagnosticCenterId,int testId);//doubt
	public DiagnosticCenter getDiagnosticCenter(String centerName);
	public DiagnosticCenter removeDiagnosticCenter(int id);
	public List<Appointment> getListOfAppointments(String centerName);
}
