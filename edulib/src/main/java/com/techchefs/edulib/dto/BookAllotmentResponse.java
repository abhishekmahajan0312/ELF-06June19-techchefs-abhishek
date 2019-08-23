package com.techchefs.edulib.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
public class BookAllotmentResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<BookAllotment> bookAllotmentBeans;
}
