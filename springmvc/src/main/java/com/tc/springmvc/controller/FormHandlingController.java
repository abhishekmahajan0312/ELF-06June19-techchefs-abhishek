package com.tc.springmvc.controller;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tc.springmvc.dto.UserBean;

@Controller
@RequestMapping("/forms")
public class FormHandlingController {
	@GetMapping("/getForm")
	public String getForm() {
		return "MyForm";
	}
	@PostMapping("/formSubmit")
	public String submitForm(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("userId"));
		String password = req.getParameter("password");
		
		req.setAttribute("userId", id);
		req.setAttribute("password", password);
		
		return "formDataDisplay";
	}
	@PostMapping("/formSubmit2")
	public String SubmitForm2(int userId,String password, ModelMap map) {
		map.addAttribute("userId", userId);// When we save any attribute in modelmap object it transfers the data in request object only. So we can fetch the values from request object as we do normally
		map.addAttribute("password", password);
		return "formDataDisplay";
	}
	@PostMapping("/formSubmit3")
	public String submitForm3(UserBean userBean,ModelMap modelMap) {
		
		modelMap.addAttribute("userBean",userBean);
		return "formDataBeanDisplay";
	}
	@PostMapping("/formSubmit4")
	public String submitForm4(@RequestParam(name="userId") int id,@RequestParam(name="password") String pass,ModelMap map) //4th way to get the form data and return the view page
	{
		map.addAttribute("userId", id);
		map.addAttribute("password", pass);
		return "formDataDisplay";
		
	}
	@PostMapping("/formSubmit5")
	public String submitForm5(@RequestParam(name="userId") int id,@RequestParam(name="password") String pass,ModelMap map) //4th way to get the form data and return the view page
	{
		map.addAttribute("userId", id);
		map.addAttribute("password", pass);
		return "formDataDisplayEL";
	}
	@PostMapping("/formSubmit6")
	public String submitForm6(UserBean userBean,ModelMap modelMap) {
		modelMap.addAttribute("userBean",userBean);
		return "formDataBeanDisplayEL";
	}
}
