package com.cg.hcs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_tbl")
public class Patient {
	@Id
	@Column(name = "patientid")
	private Integer patientid;
	
	@Column(name = "name",length=20)
	private String name;
	
	@Column(name = "phoneNo",length=10)
	private String phoneNo;
	
	@Column(name = "age",length=2)
	private Integer age;
	
	@Column(name = "gender",length=2)
	 private String gender;
	
	

	public Patient(Integer patientid, String name, String phoneNo, Integer age, String gender) {
		super();
		this.patientid = patientid;
		this.name = name;
		this.phoneNo = phoneNo;
		this.age = age;
		this.gender = gender;
	}

	public Integer getPatientid() {
		return patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Patient [patientid=" + patientid + ", name=" + name + ", phoneNo=" + phoneNo + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
	
	

}
