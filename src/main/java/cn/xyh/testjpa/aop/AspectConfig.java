package cn.xyh.testjpa.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectConfig {


    @Pointcut("execution(public * cn.xyh.testjpa.controller.*(..))")
    public void testPointcut() {}

    @Before("testPointcut()")
    public void haha () {
        System.out.println("before execute print 'haha'");
    }

    @AfterReturning("testPointcut()")
    public void xixi () {
        System.out.println("after execute print 'xixi'");
    }
}
