package com.simple.controller;

import com.simple.dao.PersonRepository;
import com.simple.pojo.Person;
import com.simple.util.EmailUtil;
import com.simple.util.Jwtutil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-12 16:13
 **/
@Slf4j
@RestController
public class IndexController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    EmailUtil emailUtil;

    /**
     * @exception:
     * @DESP: 未登录
     * @Date: 2020/6/12 cai
     */
    @RequestMapping("/noLogin")
    public Map<String, Object> noLogin(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "登陆啊大哥");
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 登录成功
     * @Date: 2020/6/12 cai
     */
    @RequestMapping("/loginSuccess")
    public Map<String, Object> succ(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Person person = personRepository.findPersonByEmail(email);
        String token = Jwtutil.getJwt(person.getId(), email);
        List<GrantedAuthority> list = (List<GrantedAuthority>) authentication.getAuthorities();
        map.put("token", token);
        map.put("role", list);
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 登陆失败
     * @Date: 2020/6/12 cai
     */
    @RequestMapping("/loginFail")
    public Map<String, Object> err(HttpServletRequest request) {
        AuthenticationException exception = (AuthenticationException) request.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        Map<String, Object> map = new HashMap<>();
        map.put("error", exception.getMessage());
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 权限不足
     * @Date: 2020/6/12 cai
     */
    @RequestMapping("/access")
    public Map<String, Object> access(HttpServletRequest request) {
        AccessDeniedException exception = (AccessDeniedException) request.getAttribute("SPRING_SECURITY_403_EXCEPTION");
        Map<String, Object> map = new HashMap<>();
        map.put("error", exception.getMessage());
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 测试权限
     * @Date: 2020/6/12 cai
     */
    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/user")
    public Map<String, Object> user(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "user");
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 测试权限
     * @Date: 2020/6/12 cai
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/admin")
    public Map<String, Object> admin(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "admin");
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 测试权限
     * @Date: 2020/6/12 cai
     */
    @PreAuthorize("hasRole('info')")
    @RequestMapping("/info")
    public Map<String, Object> info(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "info");
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 测试登出
     * @Date: 2020/6/12 cai
     */
    @RequestMapping("/logout")
    public Map<String, Object> logout(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "info");
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 发送邮件
     * @Date: 2020/6/16 cai
     */
    @RequestMapping("/open/sendEmail")
    public Map<String, Object> sendMail(HttpServletRequest request,
                                        @RequestParam String email) {
        emailUtil.sendEmail(email);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "发送成功");
        map.put("uri", request.getRequestURI());
        return map;
    }

    /**
     * @exception:
     * @DESP: 注册
     * @Date: 2020/6/16 cai
     */
    @RequestMapping("/open/register")
    public Map<String, Object> register(HttpServletRequest request,
                                        @RequestParam String email,
                                        @RequestParam String code,
                                        @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        try {
            String tempCode = (String) EmailUtil.codes.get(email);
            if (code.equals(tempCode)) {
                String newPass = passwordEncoder.encode(password);
                Person person = new Person(email, newPass, "ROLE_ADMIN","ROLE_USER");
                personRepository.save(person);
                log.info("注册成功:{}", person);
                map.put("msg", "创建成功");
            }
        } catch (Exception e) {
            map.put("msg", "创建失败");
        }
        map.put("uri", request.getRequestURI());
        return map;
    }
}
