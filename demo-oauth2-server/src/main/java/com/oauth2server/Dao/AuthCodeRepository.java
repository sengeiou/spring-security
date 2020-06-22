package com.oauth2server.Dao;


import com.oauth2server.pojo.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthCodeRepository extends JpaRepository<AuthCode, Long> {

    AuthCode findByCode(String code);
}
