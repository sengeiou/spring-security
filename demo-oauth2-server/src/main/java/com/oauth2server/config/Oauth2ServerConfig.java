package com.oauth2server.config;

import com.oauth2server.oauth2.CustomClientDetailService;
import com.oauth2server.oauth2.CustomCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-19 13:38
 * http://localhost:50000/oauth/authorize?response_type=code&client_id=quan&scope=all&state=test&redirect_uri=http://example.com
 * localhost:50000/oauth/token?grant_type=authorization_code&code=qELGB5&redirect_uri=http://example.com
 * AuthorizationEndpoint 配置认证请求
 **/
@Configuration
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {
    //AuthorizationEndpoint
    @Autowired
    CustomClientDetailService customClientDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    CustomCodeService customCodeService;
    @Autowired
    DataSource dataSource;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
     clients.withClientDetails(customClientDetailService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.authorizationCodeServices(customCodeService);
        endpoints.approvalStoreDisabled();
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.POST);
        endpoints.tokenStore(new JdbcTokenStore(dataSource));
    }
}
