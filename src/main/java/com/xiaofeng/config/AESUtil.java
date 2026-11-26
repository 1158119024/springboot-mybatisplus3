package com.xiaofeng.config;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * AES加解密工具类
 */
public class AESUtil {

    private static final String ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * 生成AES密钥
     * @param keySize 密钥长度(128, 192, 256)
     * @return Base64编码的密钥字符串
     */
    public static String generateKey(int keySize) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(keySize);
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * AES加密
     * @param content 待加密内容
     * @param key 密钥(Base64编码)
     * @return 加密后的内容(Base64编码)
     */
    public static String encrypt(String content, String key) throws Exception {
        return encrypt(content, key, null);
    }

    /**
     * AES加密(CBC模式)
     * @param content 待加密内容
     * @param key 密钥(Base64编码)
     * @param iv 初始化向量(Base64编码)，为空时自动生成
     * @return 加密后的内容(Base64编码)
     */
    public static String encrypt(String content, String key, String iv) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);

        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        byte[] ivBytes;

        if (iv == null || iv.isEmpty()) {
            // 自动生成IV
            ivBytes = new byte[16];
            new SecureRandom().nextBytes(ivBytes);
        } else {
            ivBytes = Base64.getDecoder().decode(iv);
        }

        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));

        // 将IV和密文一起返回(IV在前)
        byte[] result = new byte[ivBytes.length + encrypted.length];
        System.arraycopy(ivBytes, 0, result, 0, ivBytes.length);
        System.arraycopy(encrypted, 0, result, ivBytes.length, encrypted.length);

        return Base64.getEncoder().encodeToString(result);
    }

    /**
     * AES解密
     * @param content 待解密内容(Base64编码)
     * @param key 密钥(Base64编码)
     * @return 解密后的内容
     */
    public static String decrypt(String content, String key) throws Exception {
        byte[] contentBytes = Base64.getDecoder().decode(content);
        byte[] keyBytes = Base64.getDecoder().decode(key);

        // 提取IV(前16字节)
        byte[] ivBytes = new byte[16];
        System.arraycopy(contentBytes, 0, ivBytes, 0, 16);

        // 提取密文(剩余部分)
        byte[] encryptedBytes = new byte[contentBytes.length - 16];
        System.arraycopy(contentBytes, 16, encryptedBytes, 0, encryptedBytes.length);

        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decrypted = cipher.doFinal(encryptedBytes);

        return new String(decrypted, "UTF-8");
    }
}

