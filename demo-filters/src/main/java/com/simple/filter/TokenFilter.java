package com.simple.filter;

import com.simple.pojo.Person;
import com.simple.util.Jwtutil;
import io.jsonwebtoken.Claims;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-16 13:21
 **/
@Order(0)
@Component
public class TokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("token");
        if (!(StringUtils.isEmpty(token))) {
            Claims claims = Jwtutil.parseToken();
            if (claims != null) {
                String username = claims.getIssuer();
                Person person = new Person(username, "", "ROLE_USER", "ROLE_ADMIN");
                SecurityContextHolder.getContext().setAuthentication((Authentication) person);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
