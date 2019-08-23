package com.techchefs.edulib.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName("employee-response")
@Data
public class UserResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<User> beans;
}
