package org.jxx.aop.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description: TODO
 * @Author: javaear
 * @Version: 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(org.jxx.aop.handler.LogAdvisor.class)
public @interface EnableSpringLog {

}
