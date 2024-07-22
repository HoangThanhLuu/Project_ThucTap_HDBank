package com.example.demoTTS2.Component;

import com.example.demoTTS2.Model.UserEntity;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtTokenUtil {
    private int expiration=2592000; //30 days
    private final Key signKey;
    public JwtTokenUtil() {
        this.signKey = getSignKey();

    }
    public String generateToken(UserEntity userEntity){
        Map<String, Object> claims = new HashMap<>();
        claims.put("username",userEntity.getUsername());
        try {String token=Jwts.builder()
                .setClaims(claims)
                .setSubject(userEntity.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+expiration*1000L))
                .signWith(signKey, SignatureAlgorithm.HS256).compact();
            return token;
    } catch (Exception e) {
            System.err.println("Cannot create JWT Token"+e.getMessage());
            return null;
        }
}

    private Key getSignKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] signKeyBytes = new byte[32]; // 256-bit SignKey
        secureRandom.nextBytes(signKeyBytes);
        return new SecretKeySpec(signKeyBytes, "HmacSHA256");
    }

    private Claims extractAllClaim(String token) {
        return Jwts.parserBuilder() .setSigningKey(signKey).build().parseClaimsJws(token).getBody();
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsTFunction) {
        final Claims claims= this.extractAllClaim(token);
        return claimsTFunction.apply(claims);
    }
    public boolean isTokenExpired(String token){
    Date expirationDate= this.extractClaim(token,Claims::getExpiration);
    return expirationDate.before(new Date());
    }
    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
