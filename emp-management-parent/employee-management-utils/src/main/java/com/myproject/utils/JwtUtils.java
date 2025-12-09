package com.myproject.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
/**
 * Jwt工具類別
 * token組成:
 * header.payload.signature
 * header: typ(類型), alg(加密演算法), base64 encoded
 * payload: 資料, exp(有效期間), iat(發行時間), base64 encoded
 * signature: header+payload+secretKey產生的簽名
 */
public class JwtUtils {
    // 設置密鑰
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("astringsecretatleast256bitslongformyproject".getBytes());
    // 設置token有效時間
    private static final long EXPIRATION_TIME = 3600 * 1000;

    public static String generateJwt(Map<String, Object> dataMap){
        String jwt = Jwts.builder()
                .signWith(SECRET_KEY)
                .addClaims(dataMap) // 添加自訂資訊
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 設置過期時間
                .compact(); // 生成令牌
        return jwt;
    }

    public static Claims parseJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
