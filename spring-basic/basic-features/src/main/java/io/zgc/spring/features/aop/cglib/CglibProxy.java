package io.zgc.spring.features.aop.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    @Override
    public Object intercept(Object obj, Method method, Object[] argus, MethodProxy methodProxy) throws Throwable {
        //PerformanceMonitor.begion
        Object result = methodProxy.invokeSuper(obj, argus);
        return result;
    }
}
