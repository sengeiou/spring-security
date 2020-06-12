package com.simple.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Person implements UserDetails {
    private String email;
    private String password;
    private Collection<GrantedAuthority> collection;

    public Person() {
    }
    public Person(String email,String password,String...args) {
        this.email =email;
        this.password=password;
        List<GrantedAuthority> list = new ArrayList<>();
        for (int i=0;i<args.length;i++){
            int finalI = i;
            list.add((GrantedAuthority)()->args[finalI]);
        }
        this.collection = list;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
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
}
