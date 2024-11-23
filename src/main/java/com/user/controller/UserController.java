package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.DTO.UserDTO;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	// add user 
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		UserDTO user = userService.addUser(userDTO);
		return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
	}
	
	// find users by id
	@GetMapping("fetchUserById/{userId}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable Integer userId) {
		return userService.findUserById(userId);
	}
	
	
}
