package com.cg.hcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.hcs.dao.IAdminRepository;
import com.cg.hcs.exception.UserException;
import com.cg.hcs.model.User;

public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository repo;
	@Override
	public ResponseEntity<User> registerAdmin(String username, String password) throws UserException {
		if(repo.findUserByName(username, "admin")==null) {
			User u = new User(username, password, "admin");
			repo.save(u);
				return new ResponseEntity<User>(u, HttpStatus.OK);
		}
		throw new UserException("admin with the username already exists");
	
	}

}
