package com.oauth2server.oauth2;

import com.oauth2server.Dao.AuthCodeRepository;
import com.oauth2server.pojo.AuthCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-22 13:31
 **/
@Slf4j
@Component
public class CustomCodeService implements AuthorizationCodeServices {
    OAuth2AuthenticationProcessingFilter
    @Autowired
    private AuthCodeRepository authCodeRepository;

    private RandomValueStringGenerator generator = new RandomValueStringGenerator();

    /**
     * @exception:
     * @DESP: code处理
     * @Date: 2020/6/22 cai
     */
    @Override
    public String createAuthorizationCode(OAuth2Authentication oAuth2Authentication) {
        log.info("创建code");
        String code = this.generator.generate();
        String username = oAuth2Authentication.getName();
        AuthCode authCode = new AuthCode();
        authCode.setCode(code);
        authCode.setUsername(username);
        authCodeRepository.save(authCode);
        return code;
    }

    /**
     * @param
     * @return 验证code
     * @throws InvalidGrantException
     */
    @Override
    public OAuth2Authentication consumeAuthorizationCode(String s) throws InvalidGrantException {
        AuthCode authCode = authCodeRepository.findByCode(s);
        if(authCode!=null){
            if(!authCode.getIsUse()){
                Authorization token = new UsernamePasswordAuthenticationToken();
                return token;
            }
        }
        return null;
    }
}
