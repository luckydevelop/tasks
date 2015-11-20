package com.devcolibri.hello.impl;

import com.devcolibri.hello.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld(String st) {
        System.out.println(st);
    }
}
