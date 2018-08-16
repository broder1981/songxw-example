package com.songxw.universalbox.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //用于身份认证、身份授权
        System.out.println("-----controller方法还没有执行");
        //如果不想执行controller方法了就返回false
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //可以在这里编辑ModelAndView内容
        System.out.println("-----controller方法已经执行完毕但还没有返回ModelAndView");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //统一异常处理，统一日志处理
        System.out.println("-----controller方法已经执行完毕同时返回ModelAndView后");
    }
}
