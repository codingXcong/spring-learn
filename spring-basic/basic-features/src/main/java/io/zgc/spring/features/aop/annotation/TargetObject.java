package io.zgc.spring.features.aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class TargetObject implements TargetInterface{

    public String sayHello(String name) {
        System.out.println("hello,"+name);
        return "hello---"+name;
    }

}
