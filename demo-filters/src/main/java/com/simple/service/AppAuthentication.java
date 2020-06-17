package com.simple.service;

import com.simple.pojo.Person;
import com.simple.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-15 13:48
 **/
@Slf4j
@Component
public class AppAuthentication extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    LoadUserService loadUserService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        log.info("邮件认证");
        if (userDetails == null) {
            throw new UsernameNotFoundException("认证失败");
        }
        String email = userDetails.getUsername();
        String tempCode = (String) EmailUtil.codes.get(email);
        String code = (String) usernamePasswordAuthenticationToken.getCredentials();
        log.info("code:{}", code);
//        if (!(code.equals(tempCode))) {
//            throw new UsernameNotFoundException("认证失败");
//        }
    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return loadUserService.loadUserByUsername(s);
    }
}
