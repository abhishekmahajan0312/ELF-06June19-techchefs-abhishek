package com.tc.empspringrest.controller;

import static com.tc.empspringrest.common.EMPConstants.DB_INTERACTION_TYPE;
import static com.tc.empspringrest.common.EMPConstants.PROPERTY_FILENAME;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tc.empspringrest.beans.EmployeeAddressInfoBean;
import com.tc.empspringrest.beans.EmployeeEducationInfoBean;
import com.tc.empspringrest.beans.EmployeeExperienceInfoBean;
import com.tc.empspringrest.beans.EmployeeInfoBean;
import com.tc.empspringrest.beans.EmployeeOtherInfoBean;
import com.tc.empspringrest.dao.EmployeeDao;
import com.tc.empspringrest.dao.Employees;

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

	@DeleteMapping("/removeEmployee")
	public @ResponseBody boolean deleteEmployee(@PathVariable("id")int id) {
		return dao.deleteEmployeeInfo(id);
	}

	@GetMapping(path="/getEmployee", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody EmployeeInfoBean getEmployee(@RequestParam(name = "empId") int id) {
		return dao.getEmployeeInfo(id);
	}

	@GetMapping("/getAllEmployee")
	public @ResponseBody Employees getAllEmployee() {
		Employees emps = new Employees();
		emps.setAllEmployees(dao.getAllEmployeeInfo());
		return emps;
	}

	@PostMapping("/createEmployee")
	public @ResponseBody Boolean addEmployee(@RequestBody EmployeeInfoBean bean, ModelMap map) {

		List<EmployeeEducationInfoBean> eduBeans = bean.getEducationInfoBeans();
		for (EmployeeEducationInfoBean employeeEducationInfoBean : eduBeans) {
			employeeEducationInfoBean.getEducationPKBean().setInfoBean(bean);
		}
		List<EmployeeAddressInfoBean> addressBeans = bean.getAddressInfoBeans();
		for (EmployeeAddressInfoBean employeeAddressInfoBean : addressBeans) {
			employeeAddressInfoBean.getAddressPKBean().setInfoBean(bean);
		}
		List<EmployeeExperienceInfoBean> expBeans = bean.getExperienceInfoBeans();
		for (EmployeeExperienceInfoBean employeeExperienceInfoBean : expBeans) {
			employeeExperienceInfoBean.getExperiencePKBean().setInfoBean(bean);
		}

		EmployeeOtherInfoBean otherInfo = bean.getOtherInfo();
		otherInfo.setInfoBean(bean);

		bean.setMngrId(dao.getEmployeeInfo(bean.getMngrId().getId()));
		boolean result = dao.createEmployeeInfo(bean);
		if (result) {
			map.addAttribute("msg", "Employee added Successfully!!!");
			return true;
		}
		map.addAttribute("msg", "Employee insertion failed!!!");
		return false;

	}

	@PutMapping("/updateEmployee")
	public @ResponseBody boolean updateEmployee(EmployeeInfoBean bean, int managerId, ModelMap map, HttpSession session) {

		List<EmployeeEducationInfoBean> eduBeans = bean.getEducationInfoBeans();
		for (EmployeeEducationInfoBean employeeEducationInfoBean : eduBeans) {
			employeeEducationInfoBean.getEducationPKBean().setInfoBean(bean);
		}
		List<EmployeeAddressInfoBean> addressBeans = bean.getAddressInfoBeans();
		for (EmployeeAddressInfoBean employeeAddressInfoBean : addressBeans) {
			employeeAddressInfoBean.getAddressPKBean().setInfoBean(bean);
		}
		List<EmployeeExperienceInfoBean> expBeans = bean.getExperienceInfoBeans();
		for (EmployeeExperienceInfoBean employeeExperienceInfoBean : expBeans) {
			employeeExperienceInfoBean.getExperiencePKBean().setInfoBean(bean);
		}

		EmployeeOtherInfoBean otherInfo = bean.getOtherInfo();
		otherInfo.setInfoBean(bean);

		bean.setMngrId(dao.getEmployeeInfo(managerId));
		boolean result = dao.updateEmployeeInfo(bean);
		if (result) {
			map.addAttribute("msg", "Employee updated Successfully!!!");
			session.setAttribute("bean", bean);
			return true;
		}
		map.addAttribute("msg", "Employee updation failed!!!");
		return false;
	}
}
