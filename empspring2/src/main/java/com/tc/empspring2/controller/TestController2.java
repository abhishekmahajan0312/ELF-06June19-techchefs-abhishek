package com.tc.empspring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webapp2")
public class TestController2 {
	@GetMapping("/loginPage")
	public String loginPage() {
		return "/login";
	}
}
