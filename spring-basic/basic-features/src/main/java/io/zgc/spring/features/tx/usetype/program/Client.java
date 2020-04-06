package io.zgc.spring.features.tx.usetype.program;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);

        // 事务正常回滚
        //userService.insertUser(true);

        // 事务正常提交
        userService.insertUser(false);
    }
}
