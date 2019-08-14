package com.tc.empspringrest.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName("employee-response")
@Data
public class EmployeeResponse {
	
	@JsonProperty("status-code")
	private int statusCode;
	private String message;
	private String description;
	private List<EmployeeInfoBean> beans;
}
