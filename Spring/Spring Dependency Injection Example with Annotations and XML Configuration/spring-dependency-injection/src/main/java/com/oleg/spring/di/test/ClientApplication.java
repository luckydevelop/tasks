package com.oleg.spring.di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oleg.spring.di.configuration.DIConfiguration;
import com.oleg.spring.di.consumer.MyApplication;

public class ClientApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		
		app.processMessage("Hi Pankaj", "pankaj@abc.com");
		
		//close the context
		context.close();
	}

}
