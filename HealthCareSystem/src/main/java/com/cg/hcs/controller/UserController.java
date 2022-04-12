package com.cg.hcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.exception.UserException;
import com.cg.hcs.model.User;
import com.cg.hcs.service.IAdminServiceImpl;
import com.cg.hcs.service.IUserServiceImpl;

@RestController
public class UserController {
	@Autowired
	IUserServiceImpl impl;
	@Autowired
	IAdminServiceImpl aimpl;
	@GetMapping("/validateUser/{name}/{password}")
	public ResponseEntity<User> validateUser(@PathVariable("name") String username,@PathVariable("password") String password) throws UserException{
		return impl.validateUser(username, password);
	}
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserException{
		return impl.addUser(user);
	}
	@DeleteMapping("/removeUser")
	public ResponseEntity<User> removeUser(@RequestBody User user) throws UserException{
		return impl.removeUser(user);
	}
	@PostMapping("/resgisterAdmin/{name}/{password}")
	public ResponseEntity<User> registerAdmin(@PathVariable("name") String username,@PathVariable("password") String password) throws UserException{
		return aimpl.registerAdmin(username, password);
	}
}


