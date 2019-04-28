package com.zzc.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("user")
@Scope("singleton")
/*@Scope("prototype")*/
public class User {

    private String name;
   /* @Autowired*//*设置对象类型的属性值*//*
    @Qualifier("dog")*//*根据spring 管理的id 进行属性的注入*/
    @Resource(name="dog")/*结合上面两种注解的方式，进行属性的注入*/
    private Dog dog;

    public void sayHello(){
        System.out.println("hello");
    }
    @Value("zhouzechong")
    public void setName(String name) {
        this.name = name;
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy---销毁");
    }
    @PostConstruct
    public void init(){
        System.out.println("init---初始化");
    }
   /* @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }*/

}
