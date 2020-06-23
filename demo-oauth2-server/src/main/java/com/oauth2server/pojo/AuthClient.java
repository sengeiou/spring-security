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
    private Long id;
    /**clientId*/
    private String cid;
    /**apiKey*/
    private String appId;
    /**appsecret*/
    private String appSecret;
    /**申请权限范围*/
    private String scope;
    /**授权模式 authorization_code,password,refresh_token,implicit,client_credentials*/
    private String grantTypes;
    /**跳转链接*/
    private String redirectUrl;
    /**资源*/
    private String resourceids;
    /** authorization_code,password 不需要设置权限*/
    private String authorities;
    /**有效时间*/
    private String access_token_validity;
    /**刷新token的有效时间*/
    private String refresh_token_validity;
    /**客户端相关信息*/
    private String additionalinformation;
    /**使用授权页面*/
    private Boolean autoApproveScopes;
    /**创建时间*/
    private String createTime = String.valueOf(System.currentTimeMillis());
}
