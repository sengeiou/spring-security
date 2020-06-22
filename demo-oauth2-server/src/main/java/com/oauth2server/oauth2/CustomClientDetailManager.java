package com.oauth2server.oauth2;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: clientDetailManager
 * @create: 2020-06-22 13:18
 **/
public class CustomClientDetailManager implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return null;
    }
}
