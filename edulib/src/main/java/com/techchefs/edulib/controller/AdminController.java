package com.techchefs.edulib.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchefs.edulib.dto.User;
import com.techchefs.edulib.dto.UserResponse;
import com.techchefs.edulib.repository.BookRepository;
import com.techchefs.edulib.repository.UserRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;

	@PostMapping(path = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createUser(@RequestBody User bean) {

		UserResponse response = new UserResponse();
		String password = bean.getName().substring(0,4)+((int)(Math.random()*9999));
		
		bean.setPassword(password);
		userRepository.save(bean);
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Employee data inserted successfully");
		response.setBeans(Arrays.asList(bean));
		return response;
	}
	@GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllUsers() {

		UserResponse response = new UserResponse();
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Employee data found successfully");
		response.setBeans(userRepository.findAll());
		return response;
	}

	

}
