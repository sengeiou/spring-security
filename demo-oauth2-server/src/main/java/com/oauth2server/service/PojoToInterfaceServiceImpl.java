package com.oauth2server.service;

import com.oauth2server.pojo.AuthClient;
import com.oauth2server.pojo.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Service;

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
@Service
public class PojoToInterfaceServiceImpl implements PojoToInterface {
    @Override
    public ClientDetails clientDetail(AuthClient client) {
        ClientDetails details = new ClientDetails() {
            @Override
            public String getClientId() {
                return client.getCid();
            }

            @Override
            public Set<String> getResourceIds() {
                String resources = client.getResourceids();
                Set<String> set = new HashSet<>();
                if (resources != null) {
                    if (resources.contains(",")) {
                        String[] str = resources.split(",");
                        for (int i = 0; i < str.length; i++) {
                            set.add(str[i]);
                        }
                    } else {
                        set.add(resources);
                    }
                }
                return null;
            }

            @Override
            public boolean isSecretRequired() {
                return false;
            }

            @Override
            public String getClientSecret() {
                return client.getAppSecret();
            }

            @Override
            public boolean isScoped() {
                return true;
            }

            @Override
            public Set<String> getScope() {
                String resources = client.getScope();
                Set<String> set = new HashSet<>();
                if (resources != null) {
                    if (resources.contains(",")) {
                        String[] str = resources.split(",");
                        for (int i = 0; i < str.length; i++) {
                            set.add(str[i]);
                        }
                    } else {
                        set.add(resources);
                    }
                }
                return null;
            }

            @Override
            public Set<String> getAuthorizedGrantTypes() {
                String resources = client.getGrantTypes();
                Set<String> set = new HashSet<>();
                if (resources != null) {
                    if (resources.contains(",")) {
                        String[] str = resources.split(",");
                        for (int i = 0; i < str.length; i++) {
                            set.add(str[i]);
                        }
                    } else {
                        set.add(resources);
                    }
                    return set;
                }
                return null;
            }

            @Override
            public Set<String> getRegisteredRedirectUri() {
                Set<String> set = new HashSet<>();
                set.add(client.getRedirectUrl());
                return set;
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
