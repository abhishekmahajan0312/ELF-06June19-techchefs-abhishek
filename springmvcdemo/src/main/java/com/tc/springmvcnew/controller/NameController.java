package com.tc.springmvcnew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tc.springmvcnew.model.Name;

@Controller
@RequestMapping("/name")
public class NameController {

	@GetMapping("/getNameForm")
	public String getForm() {
		return "view1";
	}
	
	@GetMapping("/getName")
	public String getName(ModelMap map) { 
		map.addAttribute("name", Name.getName());
		return "view2";
	}
	
}
