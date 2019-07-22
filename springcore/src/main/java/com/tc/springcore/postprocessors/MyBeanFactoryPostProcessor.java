package com.tc.springcore.postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("Inside Bean Factory");
		
		BeanDefinition def = beanFactory.getBeanDefinition("messageBean");
		MutablePropertyValues propertyValues = def.getPropertyValues();
		System.out.println(propertyValues.get("message"));
		propertyValues.add("message", "Message from my BFPP1");
		System.out.println(propertyValues.get("message"));
		
	}
	
}
