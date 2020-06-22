package com.oauth2server.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
public class AuthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pid;
    private String username;
    private Boolean isUse = false;
    private String code;
    private Long createTime = System.currentTimeMillis();
}
