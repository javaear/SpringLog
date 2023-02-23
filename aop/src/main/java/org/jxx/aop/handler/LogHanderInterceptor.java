package org.jxx.aop.handler;



import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jxx.aop.annotation.SpringLog;
import org.jxx.aop.type.OpType;


/**
 * @Description: TODO
 * @Author: javaear
 * @Version: 1.0
 */
@Slf4j
public class LogHanderInterceptor implements MethodInterceptor {

    /**
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        boolean isLog = invocation.getMethod().isAnnotationPresent(SpringLog.class);
        String opType = null;
        if(isLog){
            SpringLog slog = (SpringLog)invocation.getMethod().getAnnotation(SpringLog.class);
            opType = slog.opType();
        }
        if(OpType.START.getValue().equals(opType)||OpType.AROUND.getValue().equals(opType)) {
            addPrefixLog(invocation);
        }
        Object result = invocation.proceed();
        if(OpType.END.getValue().equals(opType)||OpType.AROUND.getValue().equals(opType)) {
            addSuffixLog(invocation);
        }
        return result;
    }

    /**
     * 执行前插入日志
     */
    private void addPrefixLog(MethodInvocation invocation){

        log.info("start ====== addPrefixLog");
    }

    /**
     * 执行后插入日志
     */
    private void addSuffixLog(MethodInvocation invocation){

        log.info("end ====== addSuffixLog");
    }
}
