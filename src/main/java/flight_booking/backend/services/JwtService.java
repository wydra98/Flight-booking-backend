package flight_booking.backend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;

@Service
public class JwtService {
    private final Algorithm algorithm;
    private final JWTVerifier verifier;

    public JwtService() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String secret = new String(array, StandardCharsets.UTF_8);
        algorithm = Algorithm.HMAC256(secret);
        verifier = JWT.require(algorithm).build();
    }

    public String sign(String email, String role) {
        try {

            String dupa = JWT.create()
                    .withClaim("email", email)
                    .withClaim("role", role)
                    .withExpiresAt(Date.from(ZonedDateTime.now().plusDays(7).toInstant()))
                    .sign(algorithm);
            return dupa;


        } catch (JWTCreationException ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Błąd podczas tworzenia tokenu!");
        } catch (JWTVerificationException e) {
            throw new IllegalStateException();
        }
    }


    public DecodedJWT verify(String token) throws JWTVerificationException {
        try {
            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new IllegalStateException();
        }
    }

}
