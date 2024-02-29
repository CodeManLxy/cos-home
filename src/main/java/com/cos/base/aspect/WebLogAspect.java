package com.cos.base.aspect;

import cn.hutool.core.util.ObjectUtil;
import com.quantz.common.response.ResponseData;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author wangtong
 * @create 2023/11/2 13:50
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = Logger.getLogger(getClass());

    private long startTime = 0;

    @Pointcut("execution( * com.quantz.*.controller..*.*(..))")
    //com.myspringboot.controller  为Controller所在的包名
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime = System.currentTimeMillis();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (!request.getRequestURL().toString().contains("collect")) {
            // 记录下请求内容
            logger.info("---------------request----------------");
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("HTTP_METHOD : " + request.getMethod());
            logger.info("IP : " + request.getRemoteAddr());

            Enumeration enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                String name = (String) enu.nextElement();
                logger.info("name:" + name + " - value:" + request.getParameter(name));
            }
        }
    }


    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {

        ResponseData responseData = (ResponseData) ret;
        if (ObjectUtil.isNotEmpty(responseData.getData()) && !"1".equals(responseData.getData().toString())) {
            logger.info("---------------response----------------");
            logger.info("RESPONSE : " + responseData.getData().toString());
            logger.info("花费时间 : " + (System.currentTimeMillis() - startTime) + "毫秒");
        } else {
            logger.info("RESPONSE : " + "");
        }
        // 处理完请求，返回内容


    }
}


