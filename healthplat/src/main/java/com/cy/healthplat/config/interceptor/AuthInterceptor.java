package com.cy.healthplat.config.interceptor;

import com.cy.healthplat.common.constant.AuthConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.URLDecoder;



public class AuthInterceptor implements HandlerInterceptor {
    private String allowRole;

    public AuthInterceptor(String allowRole) {
        this.allowRole = allowRole;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //预检请求（OPTIONS 方法），直接放行
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        String userRole = request.getHeader(AuthConstant.HEADER_USER_ROLE);
        userRole = URLDecoder.decode(userRole, "UTF-8").replace("\"", "");
//        System.out.println("解码后的值：" + userRole); // 确认是否正确
        if(userRole ==null || userRole.isEmpty()){
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"code\":401,\"msg\":\"请先登录\"}");
            out.flush();
            return false;
        }

        if(!allowRole.equals(userRole)){
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"code\":403,\"msg\":\"无权限访问，仅"+allowRole+"可操作\"}");
            out.flush();
            return false;
        }
        return true;
    }
}
