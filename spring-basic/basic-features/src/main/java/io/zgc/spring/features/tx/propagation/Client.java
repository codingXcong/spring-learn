package io.zgc.spring.features.tx.propagation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);

        userService.insetBatchUserWithRequred();

        //userService.insetBatchUserWithRequredNew();
    }
}
