package com.oauth2server.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: token
 * @create: 2020-06-23 15:36
 **/
@Setter
@Getter
@Entity
@Table
public class AuthAccessToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String token;
    private String cid;
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());

}
