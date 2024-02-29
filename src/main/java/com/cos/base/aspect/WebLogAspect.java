package com.cos.base.aspect;

import cn.hutool.core.util.ObjectUtil;
import com.cos.base.config.base.response.ResponseData;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class WebLogAspect {
    

    private long startTime = 0;

    @Pointcut("execution( * com.cos.*.controller..*.*(..))")
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
            log.info("---------------request----------------");
            log.info("URL : " + request.getRequestURL().toString());
            log.info("HTTP_METHOD : " + request.getMethod());
            log.info("IP : " + request.getRemoteAddr());

            Enumeration enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                String name = (String) enu.nextElement();
                log.info("name:" + name + " - value:" + request.getParameter(name));
            }
        }
    }


    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {

        ResponseData responseData = (ResponseData) ret;
        if (ObjectUtil.isNotEmpty(responseData.getData()) && !"1".equals(responseData.getData().toString())) {
            log.info("---------------response----------------");
            log.info("RESPONSE : " + responseData.getData().toString());
            log.info("花费时间 : " + (System.currentTimeMillis() - startTime) + "毫秒");
        } else {
            log.info("RESPONSE : " + "");
        }
        // 处理完请求，返回内容


    }
}


