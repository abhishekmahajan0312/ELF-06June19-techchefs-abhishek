package com.tc.springcore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.tc.springcore.beans.MessageBean;

@Configuration  //This is equivalent to the <beans> tag in the config.xml file.This tells that this class is a configuration file in spring
public class MessageConfiguration {
	@Bean// This is equivalent to the <bean> tag in the config.xml file. This tells the spring container that this is the bean.
	@Scope("prototype")//If we don't specify the scope then in message test see comment on line no 25 
	public MessageBean getMessageBean() {
		MessageBean msgBean = new MessageBean(); //The IoC container doesnot create the new object if we don't specify the scope and returns the previous object
		msgBean.setMessage("Hello World");
		return msgBean;
	}
}//End Of Config Class