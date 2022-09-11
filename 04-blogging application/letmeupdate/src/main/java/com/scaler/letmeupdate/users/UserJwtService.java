package com.scaler.letmeupdate.users;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserJwtService {


    private static String SECRET="jbhv31iug08asdfh10i4u3vt01u48y8g08hbngqojrbg";

    private static String CLAIM_USER="username";

    private static int expirationDate= 120000;  // 2 min

    Algorithm algorithm = Algorithm.HMAC256(SECRET);

    public String createJwtTokenFromUsername(String username){
        return  JWT.create()
                .withClaim(CLAIM_USER,username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(new Date().getTime()+expirationDate))
                .sign(algorithm);
    }
    public String getUsernameFromJwtToken(String jwtToken){
        return JWT.require(algorithm)
                .build()
                .verify(jwtToken)
                .getClaim(CLAIM_USER)
                .asString();
    }

}
