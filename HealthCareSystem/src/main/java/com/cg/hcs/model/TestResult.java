package com.cg.hcs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testresult_tbl")
public class TestResult {
	@Id
	@Column(name = "Id")
	private Integer id;
	@Column(name = "TestReading")
	private Double testReading;
	@Column(name = "Condition",length=20)
	private String condition;
	private Appointment appointment;
	
	public TestResult() {
		super();
	}
	public TestResult(Integer id, Double testReading, String condition,Appointment appointment) {
		super();
		this.id = id;
		this.testReading = testReading;
		this.condition = condition;
		this.appointment=appointment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getTestReading() {
		return testReading;
	}
	public void setTestReading(Double testReading) {
		this.testReading = testReading;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "TestResult [id=" + id + ", testReading=" + testReading + ", condition=" + condition + ", appointment="
				+ appointment + "]";
	}
}
