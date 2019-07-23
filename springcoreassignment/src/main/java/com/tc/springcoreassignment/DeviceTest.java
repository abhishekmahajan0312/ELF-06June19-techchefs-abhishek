package com.tc.springcoreassignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tc.springcoreassignment.config.BeanConfig;
import com.tc.springcoreassignment.interfaces.HP;
import com.tc.springcoreassignment.interfaces.Laptop;

/**
 * Hello world!
 *
 */
public class DeviceTest 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	Laptop dell = (Laptop)context.getBean("dell");
		dell.display();
		dell.process();
		dell.showSpecification();
		ApplicationContext context2 = new AnnotationConfigApplicationContext(BeanConfig.class);
    	Laptop hp = (Laptop)context2.getBean(HP.class);
		hp.display();
		hp.process();
		hp.showSpecification();
    }
}
