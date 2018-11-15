package cn.xyh.testjpa.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class AspectService implements ThrowsAdvice {

    @Pointcut("execution(ex)")
    public void test () {}

    Logger logger = LoggerFactory.getLogger(AspectService.class);
    //配置抛出异常后通知,使用在方法aspect()上注册的切入点
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        logger.info("进入切面AfterThrowing方法中...");
        //判断日志输出级别
        if (logger.isInfoEnabled()) {
            logger.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
        }

        //详细错误信息
        String errorMsg = "";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            errorMsg += "\tat " + s + "\r\n";
        }
        //写入异常日志
        writeLog(errorMsg, joinPoint, ex);
    }

    /**
     * @param detailErrMsg 详细错误信息
     * @Description: 日志异常
     * @author： Ma
     * @createTime： 2016-10-14
     */

    public void writeLog(String detailErrMsg, JoinPoint joinPoint, Exception ex) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取请求的URL
        StringBuffer requestURL = request.getRequestURL();
        //获取参 数信息
        String queryString = request.getQueryString();
        //封装完整请求URL带参数
        if (queryString != null) {
            requestURL.append("?").append(queryString);
        }
        String cla = joinPoint.getTarget().getClass().getName();//action
        String method = joinPoint.getSignature().getName();//method
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //FileOutputStream out=new FileOutputStream(file,false); //如果追加方式用true
        //日志具体参数
        StringBuffer sb = new StringBuffer();
        sb.append("-----------" + sdf.format(new Date()) + "------------\r\n");
        sb.append("远程请求URL[" + requestURL + "]\r\n");
        sb.append("接口方法：[" + cla + "." + method + "]\r\n");
        sb.append("详细错误信息：" + ex + "\r\n");
        sb.append(detailErrMsg + "\r\n");
        logger.info(String.valueOf(sb));
    }
}
