package com.simple.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: 登出
 * @create: 2020-06-15 11:35
 **/
@Slf4j
public class LogoutSuccService extends SimpleUrlLogoutSuccessHandler {

    public LogoutSuccService() {
        super.setDefaultTargetUrl("/logout");
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登出成功");
        String targetUrl = this.determineTargetUrl(request, response, authentication);
        RequestDispatcher dispatcher = request.getRequestDispatcher(targetUrl);
        dispatcher.forward(request, response);
    }

}
