package io.zgc.spring.features.ioc;

import io.zgc.spring.features.ioc.bean.MyTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextSample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyTestBean myTestBean = context.getBean(MyTestBean.class);
        System.out.println(myTestBean.getMsg());

    }
}
