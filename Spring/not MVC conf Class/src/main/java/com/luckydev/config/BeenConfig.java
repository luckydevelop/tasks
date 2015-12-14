package com.luckydev.config;

import com.luckydev.hello.impl.HelloWorldImpl;
import com.luckydev.hello.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeenConfig {

    @Bean(name="helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

}
