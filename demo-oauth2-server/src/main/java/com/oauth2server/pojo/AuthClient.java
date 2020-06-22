package com.oauth2server.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-22 15:01
 **/
@Setter
@Getter
@Entity
@Table
public class AuthClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String appId;
    private String resourceids;
    private String appSecret;
    private String scope;
    private String grantTypes;
    private String redirectUrl;
    private String authorities;
    private String access_token_validity;
    private String refresh_token_validity;
    private String additionalinformation;
    private String autoApproveScopes;
}
