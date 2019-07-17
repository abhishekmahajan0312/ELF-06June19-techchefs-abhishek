package com.tc.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MessageBean {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@PostConstruct   //3rd Method for init and destroy using Annotations
	public void init() throws Exception { // For Initializing Phase
		System.out.println("init Phase");

	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Destroy Phase");
	}

}
