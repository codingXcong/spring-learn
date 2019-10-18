package io.zgc.spring.features.ioc;

import io.zgc.spring.features.ioc.bean.MyTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactorySample {
    public static void main(String[] args) {
BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
MyTestBean myTestBean = bf.getBean("myTestBean", MyTestBean.class);
System.out.println(myTestBean.getMsg());
    }
}
