package com.simple.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: 修改未登录请求的处理方式
 * @create: 2020-06-15 11:08
 **/
@Slf4j
public class NoLoginService extends LoginUrlAuthenticationEntryPoint {
   
    public NoLoginService(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("未登录请求");
        String loginForm = this.determineUrlToUseForThisRequest(request, response, authException);
        RequestDispatcher dispatcher = request.getRequestDispatcher(loginForm);
        dispatcher.forward(request, response);
    }
}
