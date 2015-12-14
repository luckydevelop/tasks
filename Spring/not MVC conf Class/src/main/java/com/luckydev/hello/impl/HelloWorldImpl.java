package com.luckydev.hello.impl;

import com.luckydev.hello.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld(String st) {
        System.out.println(st);
    }
}
