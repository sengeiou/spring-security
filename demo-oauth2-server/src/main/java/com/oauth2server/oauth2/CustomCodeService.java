package com.oauth2server.oauth2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oauth2server.Dao.AuthCodeRepository;
import com.oauth2server.pojo.AuthCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.stereotype.Component;


/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-22 13:31
 **/
@Slf4j
@Component
public class CustomCodeService implements AuthorizationCodeServices {
    //OAuth2AuthenticationProcessingFilter
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
        String code = this.generator.generate();
        AuthCode authCode = new AuthCode();
        authCode.setCode(code);
        ObjectMapper mapper = new ObjectMapper();
        String auth = null;
        try {
            auth = mapper.writeValueAsString(oAuth2Authentication);
            authCode.setOAuth2Authentication(auth);
            authCodeRepository.save(authCode);
            log.info("创建code:{}", code);
            return code;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InvalidGrantException("Invalid authorization code: " + e);
        }
    }

    /**
     * @param
     * @return 验证code
     * @throws InvalidGrantException
     */
    @Override
    public OAuth2Authentication consumeAuthorizationCode(String s) throws InvalidGrantException {
        AuthCode authCode = authCodeRepository.findByCode(s);
        if (authCode != null) {
            ObjectMapper mapper = new ObjectMapper();
            OAuth2Authentication oAuth2Authentication = null;
            try {
                oAuth2Authentication = mapper.readValue(authCode.getOAuth2Authentication(), OAuth2Authentication.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return oAuth2Authentication;
        } else {
            throw new InvalidGrantException("Invalid authorization code: " + s);
        }
    }
}
