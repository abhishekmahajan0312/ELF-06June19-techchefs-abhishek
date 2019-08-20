package com.tc.empspringrest.controller;

import static com.tc.empspringrest.common.EMPConstants.DB_INTERACTION_TYPE;
import static com.tc.empspringrest.common.EMPConstants.PROPERTY_FILENAME;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.web.bind.annotation.RestController;

import com.tc.empspringrest.beans.EmployeeAddressInfoBean;
import com.tc.empspringrest.beans.EmployeeEducationInfoBean;
import com.tc.empspringrest.beans.EmployeeExperienceInfoBean;
import com.tc.empspringrest.beans.EmployeeInfoBean;
import com.tc.empspringrest.beans.EmployeeOtherInfoBean;
import com.tc.empspringrest.beans.EmployeeResponse;
import com.tc.empspringrest.dao.EmployeeDao;
import com.tc.empspringrest.dao.Employees;

@CrossOrigin(origins = {"http://localhost:3000","/"})
@RestController
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

	@DeleteMapping("/removeEmployee/{id}")
//	public @ResponseBody boolean deleteEmployee(@PathVariable("id")int id) {
	public EmployeeResponse deleteEmployee(@PathVariable("id") int id, HttpServletRequest req) {

		EmployeeResponse response = new EmployeeResponse();
		HttpSession session = req.getSession(false);
		if (session != null) {
			if (dao.deleteEmployeeInfo(id)) {
				response.setStatusCode(201);
				response.setMessage("Successfull");
				response.setDescription("Employee data deleted successfully");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Employee data not deleted successfully");
			}
		} else {
//			session.invalidate();
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please Login First");
		}
		return response;
	}

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public @ResponseBody EmployeeInfoBean getEmployee(@RequestParam(name = "empId") int id) {
	public EmployeeResponse getEmployee(@RequestParam(name = "empId") int id, HttpServletRequest req) {
		EmployeeResponse response = new EmployeeResponse();
//		HttpSession session = req.getSession(false);
//		if (session!=null) {
		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		if (bean != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Employee data found successfully");
			response.setBeans(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not found");
		}
//		} else {
////			session.invalidate();
//			response.setStatusCode(501);
//			response.setMessage("Failure");
//			response.setDescription("Please Login First");
//		}
		return response;
	}

	@GetMapping(path = "/searchEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResponse searchEmployee(@RequestParam(name = "empId") int id, HttpServletRequest req) {
		EmployeeResponse response = new EmployeeResponse();
//		HttpSession session = req.getSession(false);
//		if (session!=null) {
		List<EmployeeInfoBean> beans = dao.getAllEmployeeInfoWithRestrictions(id);
		if (beans != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Employee data found successfully");
			response.setBeans(beans);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not found");
		}
//		} else {
////			session.invalidate();
//			response.setStatusCode(501);
//			response.setMessage("Failure");
//			response.setDescription("Please Login First");
//		}
		return response;
	}

//	@GetMapping("/getAllEmployee")
//	public Employees getAllEmployee() {
//		Employees emps = new Employees();
//		emps.setAllEmployees(dao.getAllEmployeeInfo());
//		return emps;
//	}
	@GetMapping(path = "/getAllEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public List<EmployeeInfoBean> getAllEmployee() {
	public EmployeeResponse getAllEmployee(HttpSession session) {
		EmployeeResponse response = new EmployeeResponse();
		if (!session.isNew()) {
			List<EmployeeInfoBean> beans = dao.getAllEmployeeInfo();

			if (beans != null) {
				response.setStatusCode(201);
				response.setMessage("Successfull");
				response.setDescription("Employee data found successfully");
				response.setBeans(beans);
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Employee data not found");
			}
		} else {
			session.invalidate();
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please Login First");
		}
		return response;

	}

	@PostMapping(path = "/createEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean bean) {

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
		if (bean.getMngrId() != null) {
			bean.setMngrId(dao.getEmployeeInfo(bean.getMngrId().getId()));
		}
		boolean result = dao.createEmployeeInfo(bean);
		EmployeeResponse response = new EmployeeResponse();
		if (result) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Employee data inserted successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee data not inserted successfully");
		}
		return response;

	}

	@PutMapping(path = "/updateEmployee", produces = { MediaType.APPLICATION_JSON_VALUE })
	// public @ResponseBody boolean updateEmployee(EmployeeInfoBean bean, int
	// managerId, HttpSession session) {
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean bean, HttpSession session) {
		EmployeeResponse response = new EmployeeResponse();
		if (!session.isNew()) {

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
			boolean result = dao.updateEmployeeInfo(bean);
			if (result) {
				response.setStatusCode(201);
				response.setMessage("Successfull");
				response.setDescription("Employee data updated successfully");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Employee data not updated successfully");
			}

		} else {
			session.invalidate();
			response.setStatusCode(501);
			response.setMessage("Failure");
			response.setDescription("Please Login First");
		}
		return response;

	}
}
