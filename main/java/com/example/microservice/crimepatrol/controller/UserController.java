package com.example.microservice.crimepatrol.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.crimepatrol.db.Users;
import com.example.microservice.crimepatrol.repository.UserRepository;
import com.example.microservice.crimepatrol.requestmodel.UserRequest;

@RestController
@EnableAutoConfiguration

public class UserController {

	@Autowired
	private UserRepository userRepository;

	public UserController() {
		// Empty Constructor
	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{uuid}")
	public ResponseEntity<Object> getUser(@PathVariable("uuid") Long uuid) {
		Optional<Users> user = userRepository.findById(uuid);
		if(user.isPresent()){
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>("uuid not found", HttpStatus.NOT_FOUND); 
	}

	@PostMapping(value = "/users")
	public ResponseEntity<Object> createUser(@RequestBody UserRequest userRequest) {
		Users users = new Users(userRequest.getName(), userRequest.getAddress(), userRequest.getDisplayName());
		users.setCreatedDate(Calendar.getInstance());
		userRepository.save(users);
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}
	
}
