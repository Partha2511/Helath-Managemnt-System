package com.cg.hcs.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_tbl")
public class Appointment {
	@Id
	@Column(name = "Id")
	private Integer id;
	@Column(name = "Appointmentdate")
	private LocalDate appointmentDate;
	@Column(name="Approvalstatus")
	private boolean approvalStatus;
	@OneToMany
	@JoinTable(name="appointment_testresult"
	,joinColumns= {@JoinColumn(name="appointment_id")}
	,inverseJoinColumns= {@JoinColumn(name="test_id")})
	private Set<DiagnosticTest> diagnosticTests = new HashSet<DiagnosticTest>();
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	@OneToOne
	@JoinColumn(name="diagnosticcenter_id")
	private DiagnosticCenter diagnosticCenter;
	@OneToMany(mappedBy="appointment")
	private Set<TestResult> testResult = new HashSet<TestResult>();

	public Appointment() {

	}

	public Appointment(int id, LocalDate appointmentDate, boolean approvalStatus, Set<DiagnosticTest> diagnosticTests,
			Patient patient, DiagnosticCenter diagnosticCenter, Set<TestResult> testResult) {
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.approvalStatus = approvalStatus;
		this.diagnosticTests = diagnosticTests;
		this.patient = patient;
		this.diagnosticCenter = diagnosticCenter;
		this.testResult = testResult;
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

	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Set<DiagnosticTest> getDiagnosticTests() {
		return diagnosticTests;
	}

	public void setDiagnosticTests(Set<DiagnosticTest> diagnosticTests) {
		this.diagnosticTests = diagnosticTests;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}

	public Set<TestResult> getTestResult() {
		return testResult;
	}

	public void setTestResult(Set<TestResult> testResult) {
		this.testResult = testResult;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDate=" + appointmentDate + ", approvalStatus=" + approvalStatus
				+ ", diagnosticTests=" + diagnosticTests + ", patient=" + patient + ", diagnosticCenter="
				+ diagnosticCenter + ", testResult=" + testResult + "]";
	}

}