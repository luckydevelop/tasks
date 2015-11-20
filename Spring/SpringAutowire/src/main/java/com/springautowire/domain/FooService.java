package com.springautowire.domain;

/**
 *
 * @author seostella.com
 */
public class FooService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String doStuff() {
        return name + ".doStuff()";
    }
}
