package com.scaler.letmeupdate.security;

import com.scaler.letmeupdate.users.UserJwtService;
import com.scaler.letmeupdate.users.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class JWTAuthManager implements AuthenticationManager {
    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private UserJwtService jwtUserService;

    @Override
    public JWTAuthentication authenticate(Authentication authentication) throws AuthenticationException {

        if(!(authentication instanceof JWTAuthentication jwtAuthentication)){
           throw new IllegalArgumentException("Authentication not supported");
        }

        String token=jwtAuthentication.getCredentials();
        String username=jwtUserService.getUsernameFromJwtToken(token);
        var userEntity=usersService.findUserEntityByUsername(username);
        jwtAuthentication.setUserEntity(userEntity);
        return jwtAuthentication;
    }
}
