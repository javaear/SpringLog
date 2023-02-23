package org.jxx.aop.handler;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @Description: TODO
 * @Author: javaear
 * @Version: 1.0
 */
public class LogAdvisor extends DefaultPointcutAdvisor{

    public static final String traceExecution = "@annotation(org.jxx.aop.annotation.SpringLog)";

    private LogAdvisor(){
        LogHanderInterceptor logHanderInterceptor = new LogHanderInterceptor();
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(traceExecution);
        this.setAdvice(logHanderInterceptor);
        this.setPointcut(aspectJExpressionPointcut);
    }
}