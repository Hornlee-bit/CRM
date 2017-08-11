package com.zhidi.filter;

import com.zhidi.system.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤
 * Created by lx on 2017/7/24.
 */

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取Session中的用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //进行验证
        if (user == null && !request.getRequestURI().equals(request.getContextPath() + "/system/user/login.action")) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            System.out.println("经过AuthFilter过滤器，用户没有登录，并且访问的不是system/user/login.action，那么栏回login.jsp页面");
            return;
        } else {
            filterChain.doFilter(request, response);
        }
        System.out.println("执行完AuthFilter过滤器");
    }

    @Override
    public void destroy() {

    }
}
