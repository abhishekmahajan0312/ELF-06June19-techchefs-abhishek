package com.tc.springcore.annotationtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.tc.springcore.beans.MessageBean;
import com.tc.springcore.configurations.MessageConfiguration;

import lombok.extern.java.Log;
@Log
public class MessageTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfiguration.class);//For Annotation Based Mapping
		((ConfigurableApplicationContext)context).registerShutdownHook();
//		MessageBean messageBean = context.getBean(MessageBean.class);//Getting the bean object by passing Class Type Argument in the message
//		
//		log.info("Message1:"+messageBean.getMessage());//Prints the message
//		
		MessageBean messageBean = context.getBean(MessageBean.class);
		MessageBean messageBean2 = context.getBean(MessageBean.class);
		
		log.info("Message1:"+messageBean.getMessage());//Prints the message
		log.info("Message2:"+messageBean2.getMessage());//Prints the message
		
		messageBean2.setMessage("Hello to Spring");//This will set the message of both messageBean and messageBean2 to the new String if we dont specify the scope to prototype in messageconfiguration file same as we did in xml
		
		log.info("Message1:"+messageBean.getMessage());//Prints the message
		log.info("Message2:"+messageBean2.getMessage());//Prints the message
		
//		((AbstractApplicationContext)context).close();
//		((ConfigurableApplicationContext)context).close();
	}
}
