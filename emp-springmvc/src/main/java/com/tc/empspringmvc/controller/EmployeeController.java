package com.tc.empspringmvc.controller;

import static com.tc.empspringmvc.common.EMPConstants.DB_INTERACTION_TYPE;
import static com.tc.empspringmvc.common.EMPConstants.PROPERTY_FILENAME;
import static com.tc.empspringmvc.common.EMPConstants.VIEW_HOMEPAGE;
import static com.tc.empspringmvc.common.EMPConstants.VIEW_LOGINPAGE;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tc.empspringmvc.beans.EmployeeInfoBean;
import com.tc.empspringmvc.dao.EmployeeDao;

@Controller
@RequestMapping("/employee")
@PropertySource(PROPERTY_FILENAME)
public class EmployeeController {

	@Autowired
	@Qualifier(DB_INTERACTION_TYPE)
	EmployeeDao dao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@GetMapping("/search")
	public String searchEmployee(int q, ModelMap map) {
		List<EmployeeInfoBean> beans = dao.getAllEmployeeInfoWithRestrictions(q);
		map.addAttribute("emplist", beans);
		return "searchemployee";
	}
	@GetMapping("/getEmployee")
	public String getEmployee(int id, ModelMap map) {
		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		map.addAttribute("bean", bean);
		return VIEW_HOMEPAGE;
	}
	@GetMapping("/createEmployeePage")
	public String createEmployee() {
		return "createemployee";
	}
	@PostMapping("/createEmployee")
		public String addEmployee(EmployeeInfoBean bean, ModelMap map) {

		boolean result = dao.createEmployeeInfo(bean);
		if (result) {
			map.addAttribute("msg", "Employee added Successfully!!!");
		} else {
			map.addAttribute("msg", "Employee insertion failed!!!");
		}
		return "login";
	}
}
