package com.boots.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;

@Component
@Log
public class JwtProvider {

    @Value("$(jwt.secret)")
    private String jwtSecret;

    /**
     * JWT token setting method <associated with Jwts.builder()>
     * @param login
     * @return Jwts
     */
    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(365).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Token validation method<associated with Jwts.parser()>
     * @param token
     * @return true or false
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.severe("invalid token");
        }
        return false;
    }

    /**
     * Method that issues a JWT token for authorization<Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody()>
     * @param token
     * @return claims.getSubject()
     */
    public String getUserFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
