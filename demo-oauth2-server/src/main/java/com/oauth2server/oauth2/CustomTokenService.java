package com.oauth2server.oauth2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: token创建 ，续约 ，refreshtoken
 * @create: 2020-06-22 13:21
 **/
@Slf4j
@Component
public class CustomTokenService extends DefaultTokenServices {
    private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();
    /**
    * @exception:
    * @DESP: token的创建
    * @Date: 2020/6/23 cai
    */
    @Override
    public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {
        String key = this.authenticationKeyGenerator.extractKey(authentication);
        OAuth2AccessToken auth2AccessToken = new DefaultOAuth2AccessToken();
        return super.createAccessToken(authentication);
    }
}
