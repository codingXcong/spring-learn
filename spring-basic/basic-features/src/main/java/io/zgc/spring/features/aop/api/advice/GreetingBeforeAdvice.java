package io.zgc.spring.features.aop.api.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object obj) throws Throwable {
        String customerName = (String) args[0];
        System.out.println("How are you! Mrs/Ms "+customerName);
        System.out.println(obj.getClass().getName()+"."+method.getName());
    }
}
