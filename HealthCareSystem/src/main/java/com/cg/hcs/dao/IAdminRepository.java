package com.cg.hcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.model.User;
@Repository
public interface IAdminRepository extends JpaRepository<User, Integer> {

}
