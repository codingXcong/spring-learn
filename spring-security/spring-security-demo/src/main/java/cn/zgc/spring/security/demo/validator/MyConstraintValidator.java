package cn.zgc.spring.security.demo.validator;

import cn.zgc.spring.security.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

   @Autowired
   private HelloService helloService;

   @Override
   public void initialize(MyConstraint constraint) {
      System.out.println("my validator init");
   }

   @Override
   public boolean isValid(Object value, ConstraintValidatorContext context) {
      helloService.greeting("tom");
      System.out.println(value);
      return true;
   }
}
