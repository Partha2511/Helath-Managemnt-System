package com.cg.hcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.cg.hcs.dao.IAdminRepository;
import com.cg.hcs.model.User;

public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository repo;
	@Override
	public ResponseEntity<User> registerUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
