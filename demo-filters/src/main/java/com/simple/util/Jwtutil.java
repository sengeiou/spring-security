package com.simple.util;

import io.jsonwebtoken.*;

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
public final class Jwtutil {

    private static final Long expire = 1000 * 60 * 60L;
    private static final String secret = "1000*60*60L";
    private static final String owner = "flutter";
    private static final String dart = "flutter";

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
                .setExpiration(new Date(expire))
                .setIssuedAt(new Date())
                .signWith(getSign(), getKey());
        return jwt.compact();
    }

    /**
     * @exception:
     * @DESP: 解析token
     * @Date: 2020/6/16 cai
     */
    public static Claims parseToken() {
        Jws<Claims> jws;
        try {
            jws = Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(dart);
        } catch (JwtException e) {
            return null;
        }
        return jws.getBody();
    }

    /**
     * 签名
     */
    public static SignatureAlgorithm getSign() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
        return signatureAlgorithm;
    }

    /**
     * 密钥
     */
    public static SecretKey getKey() {
        byte[] code = Base64.getDecoder().decode(secret);
        SecretKey key = new SecretKeySpec(code, dart);
        return key;
    }
}
