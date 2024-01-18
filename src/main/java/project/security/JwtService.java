package project.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.enums.UserRole;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtService {
    @Autowired
    private JwtProperties properties;

    public String createToken(Long userId, String email, UserRole role){
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withExpiresAt(Instant.now().plus(Duration.ofDays(1)))
                .withClaim("e", email)
                .withClaim("r", role.toString())
                .sign(Algorithm.HMAC256(properties.getSecretKey()));

    }
}
