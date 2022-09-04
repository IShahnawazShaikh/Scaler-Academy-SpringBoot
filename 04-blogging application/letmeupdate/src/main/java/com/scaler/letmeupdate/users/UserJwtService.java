package com.scaler.letmeupdate.users;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserJwtService {

    private static final String SECRET="jbhv31iug08asdfh10i4u3vt01u48y8g08hbngqojrbg";
    private static final String CLAIM_USER="username";
    Algorithm algorithm = Algorithm.HMAC256(SECRET);

    String createJwtToken(String username){
        return  JWT.create()
                .withClaim(CLAIM_USER,username)
                .withIssuedAt(new Date())   // TODO: Add expiration
                .sign(algorithm);
    }
    String getUserFromJwtToken(String jwtToken){
        return JWT.require(algorithm)
                .build()
                .verify(jwtToken)
                .getClaim(CLAIM_USER)
                .asString();
    }

}
