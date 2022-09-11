package com.scaler.letmeupdate.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.stereotype.Service;

@Service
public class JWTAuthFilter extends AuthenticationFilter {

    /**
     *  Step : 02
     * @param authManager
     * @param authConverter
     */
    public JWTAuthFilter(JWTAuthManager authManager, JWTAuthConverter authConverter) {
        super(authManager, authConverter);

        // handle what happens when auth is successful
        this.setSuccessHandler((request, response, authentication) -> {
           /*
             the SecurityContextHolder is an object associated with every
             request. When auth succeeds we store the 'authentication' object in the context,
             Controller can then extract the user (which is the principal) from the context
           */
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
    }
}
