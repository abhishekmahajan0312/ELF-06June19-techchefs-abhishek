package com.tc.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MessageBean implements ApplicationContextAware, BeanNameAware{

	private String message;
	
	public MessageBean() {

		
	}

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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("inside App Context aware.");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("inside bean name aware "+ name);
	}

}
