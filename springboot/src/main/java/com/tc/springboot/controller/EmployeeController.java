package com.tc.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tc.springboot.beans.EmployeeAddressInfoBean;
import com.tc.springboot.beans.EmployeeEducationInfoBean;
import com.tc.springboot.beans.EmployeeExperienceInfoBean;
import com.tc.springboot.beans.EmployeeInfoBean;
import com.tc.springboot.beans.EmployeeOtherInfoBean;
import com.tc.springboot.beans.EmployeeResponse;
import com.tc.springboot.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;

	@GetMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
	public String helloWorld() {
		return "Hello World";
	}

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse createEmployee(@RequestBody EmployeeInfoBean bean) {

		EmployeeResponse response = new EmployeeResponse();
		if (!repository.existsById(bean.getId())) {
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

			bean.setMngrId(repository.findById(bean.getMngrId().getId()).get());

			repository.save(bean);
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Employee data inserted successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee already exists");

		}
		return response;
	}

	@GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(int id) {
		EmployeeInfoBean bean = repository.findById(id).get();
		EmployeeResponse response = new EmployeeResponse();
		if (bean != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("Employee data found successfully");
			response.setBeans(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee data not found");
		}
		return response;
	}

	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if (!repository.existsById(bean.getId())) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee does not exists");
			return response;
		}
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
		EmployeeInfoBean mngrId = repository.findById(bean.getMngrId().getId()).get();
		bean.setMngrId(mngrId);
		repository.save(bean);
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Employee data inserted successfully");

		return response;
	}
	@DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@RequestParam(name = "id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (!repository.existsById(id)) {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee does not exists");
			return response;
		}
		repository.delete(repository.findById(id).get());
		response.setStatusCode(201);
		response.setMessage("Successfull");
		response.setDescription("Employee data deleted successfully");

		return response;
	}
}
