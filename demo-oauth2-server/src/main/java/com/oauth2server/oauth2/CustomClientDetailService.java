package com.oauth2server.oauth2;

import com.oauth2server.Dao.AuthClientRepository;
import com.oauth2server.pojo.AuthClient;
import com.oauth2server.service.PojoToInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Component;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: clientDetailManager
 * @create: 2020-06-22 13:18
 **/
@Component
@Slf4j
public class CustomClientDetailService implements ClientDetailsService {
    @Autowired
    PojoToInterface pojoToInterface;
    @Autowired
    AuthClientRepository authClientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        log.info("ask...");
        try {
            AuthClient authClient = authClientRepository.findByCid(s);
            ClientDetails details = pojoToInterface.clientDetail(authClient);
            return details;
        } catch (Exception e) {
            throw new NoSuchClientException("No client with requested id: " + s);
        }
    }
}
