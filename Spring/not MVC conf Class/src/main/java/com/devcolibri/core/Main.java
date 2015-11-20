package com.devcolibri.core;

import com.devcolibri.config.BeenConfig;
import com.devcolibri.hello.HelloWorld;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws BeansException
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeenConfig.class);
        HelloWorld obj = (HelloWorld)context.getBean("helloBean");

        obj.sayHelloWorld("Hello World and DevColibri.com!");

    }

}
