package com.sandeep.authserver.service;

import com.sandeep.authserver.model.AuthRequest;
import com.sandeep.authserver.model.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.el.parser.Token;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    private final String secret_key="sandeep";

    public TokenResponse createJWTToken(AuthRequest request){
        return new TokenResponse(Jwts.builder().claim("username", request.getUserName())
                .claim("authorties", request.getAuhorties())
                .setSubject("jwt-token").setExpiration(new Date(System.currentTimeMillis()+30000)).compact());
               // .signWith(SignatureAlgorithm.HS256,secret_key).compact();
    }
}
