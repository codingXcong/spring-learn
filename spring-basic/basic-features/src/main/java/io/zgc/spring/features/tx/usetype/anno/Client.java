package io.zgc.spring.features.tx.usetype.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-ano.xml");
        UserService userService = applicationContext.getBean(UserService.class);

        // 事务正常回滚
        userService.insertUser(true);

        // 事务正常提交
        //userService.insertUser(false);
    }

}
