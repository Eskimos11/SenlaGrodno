package com.senla.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.pro.packaged.S;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;
    private final JwtProvider jwtProvider;

    public LoginFilter(JwtProvider jwtProvider, ObjectMapper objectMapper, AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.objectMapper = objectMapper;
        this.jwtProvider = jwtProvider;
    }


    @Override
    @SneakyThrows
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Credantials credantials = objectMapper.readValue(request.getInputStream(), Credantials.class);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        credantials.username,
                        credantials.password
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication){
        String token = prepareJwt(authentication);
        response.addHeader(HttpHeaders.AUTHORIZATION,token);
    }
    private String prepareJwt(Authentication authentication){
        return jwtProvider.buildToken(authentication.getName());
    }
    @Data
    static class Credantials{
        private String username;
        private String password;
    }
}
