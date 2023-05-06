package com.informatics.crud.common;

import com.informatics.crud.entity.LoginEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ali Alavi
 */

@Component
public class JwtProvider {

    private static final int expirationTime=1000*60*60*6;
    private static final String secret="1990033210";

    public String generateToken(String userName){
        Map<String,Object> claims=new HashMap<>();
        claims.put("name","ali");
        claims.put("family","alavi");
        return createToken(claims,userName);
    }

    private String createToken(Map<String,Object> claims,String userName){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(new Date(expirationTime+System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS384,secret)
                .compact();
    }

    public String extractUserName(String token){
        return extractAllClaims(token).getSubject();
    }

    public boolean validateToken(String token, LoginEntity entity){
        return entity!=null && extractUserName(token).equals(entity.getUserName()) &&
                !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractUserNameExpireDate(token).before(Date.from(Instant.now()));
    }

    private Date extractUserNameExpireDate(String token){
        return extractAllClaims(token).getExpiration();
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
