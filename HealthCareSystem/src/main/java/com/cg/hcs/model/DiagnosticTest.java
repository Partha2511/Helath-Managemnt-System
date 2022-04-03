package com.cg.hcs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diagnosticTest_tbl")
public class DiagnosticTest {
	@Id
	@Column(name="Id")
	private Integer id;
	@Column(name="TestName",length=30)
	private String testName;
	@Column(name="TestPrice")
	private double testPrice;
	@Column(name="NormalValue",length=30)
	private String normalValue;
	@Column(name="Units",length=30)
	private String units;
	private Set<DiagnosticCenter> diagnosticCenters=new HashSet<DiagnosticCenter>();
	public DiagnosticTest() {
		// TODO Auto-generated constructor stub
	}
	
	public DiagnosticTest(Integer id, String testName, double testPrice
			, String normalValue, String units,
			Set<DiagnosticCenter> diagnosticCenters) {
		this.id = id;
		this.testName = testName;
		this.testPrice = testPrice;
		this.normalValue = normalValue;
		this.units = units;
		this.diagnosticCenters = diagnosticCenters;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public double getTestPrice() {
		return testPrice;
	}
	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}
	public String getNormalValue() {
		return normalValue;
	}
	public void setNormalValue(String normalValue) {
		this.normalValue = normalValue;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public Set<DiagnosticCenter> getDiagnosticCenters() {
		return diagnosticCenters;
	}
	public void setDiagnosticCenters(Set<DiagnosticCenter> diagnosticCenters) {
		this.diagnosticCenters = diagnosticCenters;
	}
	@Override
	public String toString() {
		return "DiagnosticTest [id=" + id + ", testName=" + testName + ", testPrice=" + testPrice + ", normalValue="
				+ normalValue + ", units=" + units + ", diagnosticCenters=" + diagnosticCenters + "]";
	}
}
