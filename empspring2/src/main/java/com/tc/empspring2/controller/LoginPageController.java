package com.tc.empspring2.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tc.empspring2.beans.EmployeeInfoBean;
import com.tc.empspring2.dao.EmployeeDAOFactory;
import com.tc.empspring2.dao.EmployeeDao;

@Controller
@RequestMapping("/webapp")
public class LoginPageController {
	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(int id, String password,ModelMap map) {
		EmployeeDao dao = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		if (bean != null && bean.getPassword().equals(password)) {
			map.addAttribute("bean",bean);
			return "home";
		} else
		{
			map.addAttribute("msg","Invalid Username and Password!!!");
			return "login";
		}
	}
	@GetMapping("/searchEmployee")
	public String searchEmployee(int q,ModelMap map) {
		EmployeeDao dao = EmployeeDAOFactory.getInstance();
		List<EmployeeInfoBean> beans = dao.getAllEmployeeInfoWithRestrictions(q+"");
		map.addAttribute("emplist", beans);
		return "searchemployee";
	}
}
