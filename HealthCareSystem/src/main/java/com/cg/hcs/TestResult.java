package com.cg.hcs;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.hcs.model.Appointment;

@Entity
@Table(name = "testresult_tbl")
public class TestResult {
	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "TestReading")
	private double testReading;
	@Column(name = "Condition")
	private String condition;
	@ManyToOne
	Appointment appointment;
	public TestResult() {
		super();
	}
	public TestResult(int id, double testReading, String condition) {
		super();
		this.id = id;
		this.testReading = testReading;
		this.condition = condition;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTestReading() {
		return testReading;
	}
	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	

}
