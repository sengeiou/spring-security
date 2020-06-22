package com.oauth2server.service;

import com.oauth2server.pojo.AuthClient;
import com.oauth2server.pojo.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-22 15:19
 **/
public class PojoToInterfaceServiceImpl implements PojoToInterface{
    @Override
    public ClientDetails clientDetail(AuthClient client) {

        ClientDetails details = new ClientDetails() {
            @Override
            public String getClientId() {
                return client.getCid().toString();
            }

            @Override
            public Set<String> getResourceIds() {
                Set<String> set = new HashSet<>();
                //set.add()
                return null;
            }

            @Override
            public boolean isSecretRequired() {
                return false;
            }

            @Override
            public String getClientSecret() {
                return null;
            }

            @Override
            public boolean isScoped() {
                return false;
            }

            @Override
            public Set<String> getScope() {
                return null;
            }

            @Override
            public Set<String> getAuthorizedGrantTypes() {
                return null;
            }

            @Override
            public Set<String> getRegisteredRedirectUri() {
                return null;
            }

            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Integer getAccessTokenValiditySeconds() {
                return null;
            }

            @Override
            public Integer getRefreshTokenValiditySeconds() {
                return null;
            }

            @Override
            public boolean isAutoApprove(String s) {
                return false;
            }

            @Override
            public Map<String, Object> getAdditionalInformation() {
                return null;
            }
        };
        return details;
    }

    @Override
    public UserDetails userDetail(Person person) {
        return null;
    }
}
