package com.oauth2server.Dao;

import com.oauth2server.pojo.AuthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthClientRepository extends JpaRepository<AuthClient, Long> {


    AuthClient findByCid(String cid);
}
