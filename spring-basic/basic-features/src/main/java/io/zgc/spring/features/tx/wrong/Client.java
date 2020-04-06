package io.zgc.spring.features.tx.wrong;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        //userService.insertUserWrong1(true);

        //userService.insetUserWrong2(true);

        //userService.insertUserWrong3(true);

        /*try {
            userService.insertUserWrong4();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        //userService.insertUserRight(true);

        //userService.insertUserRight1(true);


    }
}
