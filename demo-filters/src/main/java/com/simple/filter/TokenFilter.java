package com.simple.filter;

import com.simple.dao.PersonRepository;
import com.simple.pojo.Person;
import com.simple.util.Jwtutil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@Order(0)
@Component
public class TokenFilter extends OncePerRequestFilter {
    @Autowired
    PersonRepository personRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("token filter");
        String token = httpServletRequest.getHeader("token");
        if (!(StringUtils.isEmpty(token))) {
            Claims claims = Jwtutil.parseToken(token);
            if (claims != null) {
                String username = claims.getIssuer();
                Person person = personRepository.findPersonByEmail(username);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username,"",person.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
