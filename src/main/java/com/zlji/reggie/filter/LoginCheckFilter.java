package com.zlji.reggie.filter;


import com.alibaba.fastjson.JSON;
import com.zlji.reggie.common.BaseContext;
import com.zlji.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    // 用于路径匹配
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1.获取本次请求的URI
        String requestURI = request.getRequestURI();

        // 定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs"
        };

        // 2.判断本次请求是否需要处理
        boolean check = check(urls, requestURI);

        // 3.如果不需要处理，则直接放行
        if(check){
            filterChain.doFilter(request,response);
            return;
        }

        // 4-1.判断登录状态，如果已登录则直接放行
        if(request.getSession().getAttribute("employee") != null){
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request,response);
            return;
        }

        // 4-2.判断移动端用户登录状态，如果已登录则直接放行
        if(request.getSession().getAttribute("user") != null){
            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request,response);
            return;
        }
        // 5.如果未登录则返回未登录结果，通过输出流方式向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;


    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI){
        for(String url : urls){
            boolean match = PATH_MATCHER.match(url,requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
