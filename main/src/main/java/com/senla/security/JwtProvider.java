package com.senla.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider   {

    @Value("mXwVcT3zeIkW77s93rtAtWOvXSAraSFH_csMT30-w_I")
    private String secret;
    @Value("PT10M")
    private String expiration;

    public String buildToken(String userName) {
        final Map<String, Object> claims = new HashMap<>();
        claims.put("typ", "access");
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(Instant.now()))
                .setSubject(userName)
                .setExpiration(Date.from(Instant.from(Instant.now().plus(Duration.parse(expiration).toMinutes(), ChronoUnit.MINUTES))))
                .signWith(
                        SignatureAlgorithm.HS256,
                        secret.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public String getUserNameFromToken(String token){
        final Claims claims = Jwts.parser()
                .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();

    }


}
