
package io.zgc.spring.features.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("io.zgc.spring.features.aop.annotation")
@EnableAspectJAutoProxy
public class AopConfig {
}
