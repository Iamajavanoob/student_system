package com.li.back.jwt;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
public class tool {
    // secret-key 的字节长度不同，会选择相应的加密算法。
    private final static String SECRET_KEY = "0123456789_9876543210_0934582765";
    // token 的有效期 单位是微秒 设置为 1 hour
    private final static long TOKEN_EXPIRE = 36000000;

    public static Key createKey() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }


    public static String createToken(Map<String, Object> claimMap) {
        //获取当前毫秒。
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                // 设置时间戳。
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + TOKEN_EXPIRE))
                //加入payload
                .addClaims(claimMap)
                //签名
                .signWith(createKey())
                //压缩
                .compact();
    }


    public static int checkToken(String token) {
        try {
            Jwts.parser().setSigningKey(createKey()).parseClaimsJws(token);
            return 0;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return 1;
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            return 2;
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            return 3;
        } catch (SignatureException e) {
            e.printStackTrace();
            return 4;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 5;
        }
    }


    public static Map<String, Object> parseToken(String token) {
        //生成的是map形式，包括payload的所有信息。
        return Jwts.parser()
                //对比生成的密钥
                .setSigningKey(createKey())
                //解析
                .parseClaimsJws(token)
                .getBody();
    }



}



