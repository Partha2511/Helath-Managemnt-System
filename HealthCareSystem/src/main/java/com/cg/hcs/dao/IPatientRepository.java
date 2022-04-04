package com.cg.hcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
