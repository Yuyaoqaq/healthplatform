package com.cy.healthplat.config.WebConfig;

import com.cy.healthplat.common.constant.AuthConstant;
import com.cy.healthplat.config.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //路径
//                .allowedOrigins("Http://localhost:8080","null") //来源
//                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS") //方法
//                .allowCredentials(true) //允许携带token类
//                .maxAge(3600); //预检请求缓存时间
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("x-user-role", "Content-Type") // 必须显式允许
                .allowCredentials(true)
                .maxAge(3600); //预检请求缓存时间

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor(AuthConstant.ROLE_ADMIN))
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/login");//仅作示例多此一举
    }
}
