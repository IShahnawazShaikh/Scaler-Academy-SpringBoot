package com.scaler.letmeupdate.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class JWTAuthConverter implements AuthenticationConverter {

    @Override
    public JWTAuthentication convert(HttpServletRequest request) {
        var requestHeader=request.getHeader("Authorization");
        if(requestHeader!=null && requestHeader.startsWith("Bearer ")){
            String token=requestHeader.substring(7);

            return new JWTAuthentication(token);
        }
        return null;
    }
}
