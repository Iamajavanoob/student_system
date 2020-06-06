package com.li.back.filter;

import com.li.back.jwt.tool;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
    public class passFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String uri = httpServletRequest.getRequestURI();
        if (uri.contains("hello")){
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("HERE");

        }
        else {
            String token = servletRequest.getParameter("token");
            System.out.println(token);
            int result = tool.checkToken(token);
            if (result==0){
                filterChain.doFilter(servletRequest,servletResponse);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
