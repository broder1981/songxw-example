package com.songxw.universalbox.session;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
public class HttpSessionDemo {

    @RequestMapping(value = "/createSession")
    @ResponseBody
    //测试Session的创建以及流程
    public String createSession (HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        String sessionId = "服务端创建的sessionId为:" + httpSession.getId();
        System.out.println(sessionId);
        String cookie = "客户端传过来的cookie为:" + request.getHeader("Cookie");
        System.out.println(cookie);
        return sessionId;
    }

    @RequestMapping(value = "/expiredSession")
    @ResponseBody
    //测试Session的过期
    public String expiredSession (HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.setMaxInactiveInterval(5);//5秒过期
        return httpSession.getId();
    }

    @RequestMapping(value = "/browserSession")
    @ResponseBody
    //验证浏览器关闭Session也同时关闭的假象
    public String browserSession (HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        String sessionId = "服务端创建的sessionId为:" + httpSession.getId();
        System.out.println(request.getContextPath());
        System.out.println(sessionId);
        Cookie cookie = new Cookie("JSESSIONID", httpSession.getId());
        cookie.setPath(request.getContextPath()+"/");
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
        return sessionId;
    }

    @RequestMapping(value = "/contentSession")
    //Session的内容
    public void contentSession (HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        String sessionId = httpSession.getId();
        System.out.println("服务端创建的sessionId为:" + sessionId);
        Long creationTime = httpSession.getCreationTime();
        System.out.println("session的创建时间为:" + creationTime);
        Long lastAccessedTime = httpSession.getLastAccessedTime();
        System.out.println("最近一次访问session的时间为:" + lastAccessedTime);
        int maxInactiveInterval = httpSession.getMaxInactiveInterval();
        System.out.println("session的超时时间为:" + maxInactiveInterval);
        httpSession.setAttribute("param", "songxw");
        String param = (String) httpSession.getAttribute("param");
        System.out.println("存储在session中的对应属性值为:" + param);
        ServletContext servletContext = httpSession.getServletContext();
    }

}
