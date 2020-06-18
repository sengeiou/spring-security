package com.simple.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author cainiao
 * @program: spring-securiy
 * @description: AES加密解密
 * @create: 2020-06-17 14:58
 **/
public class AesUtil {
    /**
    * @exception:
    * @DESP: AES加密
    * @Date: 2020/6/17 cai
    */
    public static byte[] encrypt(String secret, String key) {
        try {
            KeyGenerator aes = KeyGenerator.getInstance("AES");
            aes.init(256, new SecureRandom(key.getBytes()));
            SecretKey secretKey = aes.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            //密钥
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            //密码器
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = secret.getBytes("utf-8");
            //初始化密码器
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            //加密
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (Exception e) {
            return null;
        }

    }
    /**
    * @exception:
    * @DESP: 生成256位密钥
    * @Date: 2020/6/17 cai
    */
    public static SecretKey getSecretkey(String secret,String model) {
        try {
            KeyGenerator aes = KeyGenerator.getInstance(model);
            aes.init(256);
            SecretKey secretKey = aes.generateKey();
            return secretKey;
        } catch (Exception e) {
            return null;
        }

    }
}
