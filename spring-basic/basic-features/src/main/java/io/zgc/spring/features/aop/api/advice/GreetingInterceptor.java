package io.zgc.spring.features.aop.api.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        String clientName = (String) arguments[0];
        System.out.println("How are you! "+clientName);
        Object obj = invocation.proceed();
        System.out.println("Please enjoy yourself");
        return obj;
    }
}
