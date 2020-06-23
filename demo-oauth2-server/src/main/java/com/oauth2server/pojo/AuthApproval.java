package com.oauth2server.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-23 15:28
 **/
@Setter
@Getter
@Entity
@Table(name = "oauth_approvals")
public class AuthApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String clientId;
    private String scope;
    private String status;
    private Timestamp expiresAt;
    private Timestamp lastModifiedAt;
}
