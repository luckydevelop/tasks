package com.devcolibri.config;

import com.devcolibri.hello.impl.HelloWorldImpl;
import com.devcolibri.hello.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeenConfig {

    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

}
