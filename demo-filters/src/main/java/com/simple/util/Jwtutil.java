package com.simple.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description:
 * @create: 2020-06-16 13:27
 **/
@Slf4j
public final class Jwtutil {

    private static final Long expire = 3600000L;
    private static final String secret = "myappsecret+++";
    private static final String owner = "myapp";
    private static final SecretKey secretKey = AesUtil.getSecretkey(secret,"HmacSHA256");

    /**
     * @exception:
     * @DESP: 获取jwt
     * @Date: 2020/6/16 cai
     */
    public static String getJwt(Long id, String username) {
        JwtBuilder jwt = Jwts.builder()
                .setId(String.valueOf(id))
                .setIssuer(username)
                .setSubject(owner)
                .setExpiration(new Date(expire+System.currentTimeMillis()))
                .setIssuedAt(new Date())
                .signWith(secretKey);
        return jwt.compact();
    }

    /**
     * @exception:
     * @DESP: 解析token
     * @Date: 2020/6/16 cai
     */
    public static Claims parseToken(String token) {
        Jws<Claims> jws;
        try {
            jws = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
        } catch (JwtException e) {
            log.error("token解析错误:{}",e.getMessage());
            return null;
        }
        return jws.getBody();
    }
}
