package cn.zgc.spring.security.demo.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class TimeAspect {

    @Around("execution(* cn.zgc.spring.security.demo.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) {
        System.out.println("time aspect start");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is "+arg);
        }
        long start = System.currentTimeMillis();
        Object object = null;
        try {
            object = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("time aspect 耗时:"+ (System.currentTimeMillis() - start));
        System.out.println("time aspect end");
        return object;
    }
}
