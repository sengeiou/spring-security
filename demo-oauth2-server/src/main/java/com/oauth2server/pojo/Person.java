package com.oauth2server.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-12 16:28
 **/
@Setter
@Getter
@Entity
@Table
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String roles;
    @Transient
    private Collection<GrantedAuthority> collection;

    public Person() {
    }

    public Person(String email, String password, String... args) {
        this.email = email;
        this.password = password;
        List<GrantedAuthority> list = new ArrayList<>();
        String roles = "";
        for (int i = 0; i < args.length; i++) {
            int finalI = i;
            list.add((GrantedAuthority) () -> args[finalI]);
            roles += args[finalI] + ",";
        }
        this.collection = list;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (collection == null) {
            List<GrantedAuthority> list = new ArrayList<>();
            String[] rs = this.roles.split(",");
            for (int i = 0; i < rs.length; i++) {
                int finalI = i;
                list.add((GrantedAuthority) () -> rs[finalI]);
            }
            this.collection = list;
        }
        return collection;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", collection=" + collection +
                '}';
    }
}
