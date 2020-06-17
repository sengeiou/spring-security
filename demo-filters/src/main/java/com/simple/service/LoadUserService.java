package com.simple.service;

import com.simple.dao.PersonRepository;
import com.simple.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-12 15:38
 **/
@Slf4j
@Service
public class LoadUserService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("登录请求:{}",s);
        Person person = personRepository.findPersonByEmail(s);
        return person;
    }
}
