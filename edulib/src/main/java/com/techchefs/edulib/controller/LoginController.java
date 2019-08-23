package com.techchefs.edulib.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techchefs.edulib.dto.User;
import com.techchefs.edulib.dto.UserResponse;
import com.techchefs.edulib.repository.BookRepository;
import com.techchefs.edulib.repository.UserRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true")
public class LoginController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;

	@PostMapping(path = "/authenticate")
	public UserResponse authenticate(int id, String password, HttpServletRequest request) {
		UserResponse response = new UserResponse();
		if (!userRepository.existsById(id)) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Invalid Credentials!!");
			return response;
		}
		User bean = userRepository.findById(id).get();
		if (bean.getPassword().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userBean", bean);
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Login successful");
			response.setBeans(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Invalid Credentials");
		}
		return response;
	}

	@GetMapping(path = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse logout(HttpSession session) {
		session.invalidate();
		UserResponse response = new UserResponse();
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Logout successfully");
		return response;
	}

}
