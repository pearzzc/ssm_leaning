package com.zzc.demo;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    private String name;
    private String password;
    @Value("北京方便面")
    public void setName(String name) {
        this.name = name;
    }
    @Value("12345")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
