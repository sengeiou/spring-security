package com.simple.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: 发邮件
 * @create: 2020-06-16 17:02
 **/
@Component
public class EmailUtil {
    @Value("${spring.mail.username}")
    private static String email;
    @Resource
    private  JavaMailSender javaMailSender;

    public static Map<String, Object> codes = new HashMap<>();

    /**
     * @exception:
     * @DESP: 简单邮件(纯文字)
     * @Date: 2020/6/16 cai
     */
    public Boolean sendEmail(String email) {
        String code = getCoge();
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom(email);
        mail.setSubject("邮箱验证码");
        mail.setText(code);
        javaMailSender.send(mail);
        codes.put(email, code);
        return true;
    }

    /**
     * 获取随机六个字符
     */
    public String getCoge() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            char c = (char) (int) (Math.random() * 26 + 97);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        EmailUtil.email = email;
    }
}
