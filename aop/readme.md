#### 说明  实现注解拦截方法记录日志或其他业务操作。 必须是spring  beanfactory中的类方法。
1、
@SpringBootApplication
//必须添加
**@EnableSpringLog**
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

2、Example：方法行添加注解
@SpringLog(opType = "around")
public String hiAournd(){
}

#### 测试类--LogAnnoSayHiTest
2023-02-23 20:48:37.483  INFO 6896 --- [nio-8082-exec-3] o.jxx.aop.handler.LogHanderInterceptor   : start ====== addPrefixLog
hello,---------springlog
2023-02-23 20:48:37.483  INFO 6896 --- [nio-8082-exec-3] o.jxx.aop.handler.LogHanderInterceptor   : end ====== addSuffixLog
2023-02-23 20:48:41.891  INFO 6896 --- [nio-8082-exec-2] o.jxx.aop.handler.LogHanderInterceptor   : start ====== addPrefixLog
hiAournd2,---------around
2023-02-23 20:48:41.891  INFO 6896 --- [nio-8082-exec-2] o.jxx.aop.handler.LogHanderInterceptor   : end ====== addSuffixLog
hiEnd,---------hiEnd
2023-02-23 20:48:48.044  INFO 6896 --- [nio-8082-exec-4] o.jxx.aop.handler.LogHanderInterceptor   : end ====== addSuffixLog
2023-02-23 20:48:54.637  INFO 6896 --- [nio-8082-exec-6] o.jxx.aop.handler.LogHanderInterceptor   : start ====== addPrefixLog
hiStart,---------hiStart
nooooo,---------hiNo

#### 业务方法待实现
    private void addPrefixLog(MethodInvocation invocation){

        log.info("start ====== addPrefixLog");
    }
    private void addSuffixLog(MethodInvocation invocation){

        log.info("end ====== addSuffixLog");
    }