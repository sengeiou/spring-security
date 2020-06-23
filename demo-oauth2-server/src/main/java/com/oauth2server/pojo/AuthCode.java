package com.oauth2server.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-22 13:44
 **/
@Setter
@Getter
@Entity
@Table
public class AuthCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    @Column(columnDefinition = "TEXT")
    private String oAuth2Authentication;

    private Long createTime = System.currentTimeMillis();
}
