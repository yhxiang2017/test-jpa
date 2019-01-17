package cn.xyh.testjpa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class AspectConfig {

    private final static Logger log = LoggerFactory.getLogger(AspectConfig.class);

//    @Pointcut("execution(public * cn.xyh.testjpa.controller.*(..))")
    @Pointcut("execution(public * cn.xyh.testjpa.controller.*.*(..))")
    public void testPointcut() {}


    @Before("testPointcut()")
    public void doBefore (JoinPoint joinPoint) {

        //TODO 待完善完整的请求信息显示
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("----------------请求信息----------------");
        log.info("url: {}", request.getRequestURL());
        log.info("method: {}", request.getMethod());
        log.info("IP: {}", request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("Params: {}", Arrays.toString(joinPoint.getArgs()));

        System.out.println("before execute print 'haha'");
    }

    @AfterReturning("testPointcut()")
    public void doAfter () {
        System.out.println("after execute print 'xixi'");
    }

    @AfterThrowing(pointcut = "testPointcut()", throwing = "e")
    public void doThrow(JoinPoint joinPoint, Throwable e) {
        if (e != null) {
            log.info("--------------------------------开始打印异常信息--------------------------------");
            log.info(e.getMessage(), e);
            log.info("--------------------------------结束打印异常信息--------------------------------");
        }
    }
}
