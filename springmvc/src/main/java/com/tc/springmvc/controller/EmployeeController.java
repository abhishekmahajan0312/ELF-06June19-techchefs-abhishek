package com.tc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(path="/getMessage",method=RequestMethod.GET)//1st Way of mapping in which we create ModelandView object and return that view object.
	public ModelAndView getMessage() {
		
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("../WEB-INF/views/messagePage.jsp");//1 way to give path but we dont hard code the path
		modelAndView.setViewName("messagePage");
		return modelAndView;
	}
	
	@GetMapping("/seeMessage")//2nd Way of mapping in which we pass the inbuilt ModelandView object created by Spring container and return that view object.
	public ModelAndView getMessage(ModelAndView modelAndView) {
		modelAndView.setViewName("messagePage");
		return modelAndView;
	}
	
	
}
