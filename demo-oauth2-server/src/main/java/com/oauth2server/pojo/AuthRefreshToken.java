package com.oauth2server.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-23 15:39
 **/
@Setter
@Getter
@Entity
@Table(name = "oauth_refresh_token")
public class AuthRefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String token;
    private String authentication;
}
