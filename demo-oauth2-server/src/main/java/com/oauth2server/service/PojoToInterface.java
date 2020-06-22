package com.oauth2server.service;

import com.oauth2server.pojo.AuthClient;
import com.oauth2server.pojo.Person;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: authclirnt  -> clientdetail
 * @create: 2020-06-22 15:16
 **/
public interface PojoToInterface {

    ClientDetails clientDetail(AuthClient client);

    UserDetails userDetail(Person person);
}
