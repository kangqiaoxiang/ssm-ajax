package com.hand.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WenxiangLi on 2018/8/24.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String username = (String) request.getSession().getAttribute("user");
            if(null == username){
                System.out.println("你好啊");
                response.sendRedirect("login.html");
                return false;
            }
            return true;
    }

}
