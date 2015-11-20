package com.oleg.spring.di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.oleg.spring.di.services.EmailService;
import com.oleg.spring.di.services.MessageService;

@Configuration
@ComponentScan(value={"com.journaldev.spring.di.consumer"})
public class DIConfiguration {

	@Bean
	public MessageService getMessageService(){
		return new EmailService();
	}
}
