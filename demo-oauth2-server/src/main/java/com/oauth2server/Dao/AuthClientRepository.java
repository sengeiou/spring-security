package com.oauth2server.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthClientRepository {
    /**cid查询client*/
    @Query(value = "", nativeQuery = true)
    ClientDetails selectClient(Long cid);
}
