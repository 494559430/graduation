package com.qdu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chenzb on 20190421.
 */
public class LoginFilter implements Filter {
    public LoginFilter() {
        System.out.println("过滤器实例化");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getRequestURL().toString();
        if (url.indexOf("login.jsp")>=0){
            chain.doFilter(req, resp); return;
        }

        if (request.getSession().getAttribute("user")!=null){
            chain.doFilter(req, resp); return;
        }
        HttpServletResponse response = (HttpServletResponse) resp;
        response.sendRedirect("../login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
