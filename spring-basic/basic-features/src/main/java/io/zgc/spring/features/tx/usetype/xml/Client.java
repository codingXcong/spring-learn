package io.zgc.spring.features.tx.usetype.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //xml01();
        xml02();
    }

    private static void xml02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-tx.xml");
        UserService userService = applicationContext.getBean(UserService.class);

        // 事务正常回滚
        //userService.insertUser(true);

        // 事务正常提交
        userService.insertUser(false);
    }

    private static void xml01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-transactionproxyfactorybean.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceProxy");

        // 事务正常回滚
        userService.insertUser(true);

        // 事务正常提交
        //userService.insertUser(false);
    }
}
