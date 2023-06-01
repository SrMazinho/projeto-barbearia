package br.com.iesp.barbearia.service;

import Model.UserModel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import static org.springframework.security.config.Elements.JWT;

public class TokenService {
    @Service
    public static class tokenService {

        @Value("${security.jwt.token.secret-key:secret}")
        private String secretKey = "secret";

        @Value("${security.jwt.token.expire-length:3600000}")
        private long validityInMilliseconds = 3600000; // 1h

        byte[] algorithm = null;

        @PostConstruct
        protected void init() {
            secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
            Object Algorithm = null;
            byte[] bytes = secretKey.getBytes();
            algorithm = (secretKey.getBytes());
        }

        //public String gerarToken(UserModel usuario){

//        return JWT.create()
//                .withClaim("roles", usuario.getRoles().stream()
//                        .map( u -> u.getRoleName().toString())
//                        .toList())
//                .withSubject(Usurious.getUsername())
//                .withIssuer("Barbearia")
//                .withExpiresAt(Date.from(LocalDateTime.now()
//                        .plusMinutes(10)
//                        .toInstant(ZoneOffset.of("-03:00"))))
//                .sign(Algorithm.HMAC256("secreta"));

        // }

        public <TokenDto> TokenDto gerarToken(UserModel usuario) {

            List<String> roles = usuario.getRoles().stream()
                    .map( u -> u.toString()).toList();

            Date now = new Date();
            Date validity = new Date(now.getTime() + validityInMilliseconds);
            var accessToken = getAccessToken(usuario.getUsername(), roles, now, validity);
            var refreshToken = getRefreshToken(usuario.getUsername(), roles, now);


            return null;
        }

        private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
            String issuerUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath().build().toUriString();
            return JWT.chars()
                    .withIssuedAt(now)
                    .withExpiresAt(validity)
                    .withSubject(username)
                    .withIssuer(issuerUrl)
                    .sign(algorithm)
                    .strip();
        }

        private String getRefreshToken(String username, List<String> roles, Date now) {
            Date validityRefreshToken = new Date(now.getTime() + (validityInMilliseconds * 3));
            return JWT.chars()
                    .withClaim("roles", roles)
                    .withIssuedAt(now)
                    .withExpiresAt(validityRefreshToken)
                    .withSubject(username)
                    .sign(algorithm)
                    .strip();
        }

        public String getSubject(String token) {
            Object Algorithm = null;
            return JWT.require(Algorithm.HMAC256(secretKey.getBytes()))
                    .build().verify(token).getSubject();
        }

//    public TokenDto refreshToken(String refreshToken) {
//        if (refreshToken.contains("Bearer ")) refreshToken =
//                refreshToken.substring("Bearer ".length());
//
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        DecodedJWT decodedJWT = verifier.verify(refreshToken);
//        String username = decodedJWT.getSubject();
//        List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
//        return gerarToken(username, roles);
//    }

    }

}
