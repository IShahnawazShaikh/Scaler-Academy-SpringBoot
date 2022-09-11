package com.scaler.letmeupdate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     *   Step: 01
     * @param http
     * @throws Exception
     */

    @Autowired
    private JWTAuthManager jwtAuthManager;

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/users/login","/users/signup").permitAll()
                .antMatchers(HttpMethod.GET,"/articles","/h2-console").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(authenticationFilter, AnonymousAuthenticationFilter.class);
    }
    @Override
    protected JWTAuthManager authenticationManager() throws Exception {
        return jwtAuthManager;
    }
}
