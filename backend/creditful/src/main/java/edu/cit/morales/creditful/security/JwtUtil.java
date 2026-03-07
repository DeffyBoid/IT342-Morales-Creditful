package edu.cit.morales.creditful.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Secret key (in production, keep it in environment variables)
    private final String jwtSecret = "MySecretKey12345";

    // Token validity: 1 day
    private final long jwtExpirationMs = 24 * 60 * 60 * 1000;

    // Generate JWT
    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Extract email from token
    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    // Extract role from token
    public String getRoleFromToken(String token) {
        return (String) getClaims(token).get("role");
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Claims claims = getClaims(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }
}

