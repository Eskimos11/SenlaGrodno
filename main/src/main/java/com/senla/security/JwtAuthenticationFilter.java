package com.senla.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static java.util.Optional.ofNullable;
@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final String BEARER = "Bearer ";

    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtProvider jwtProvider, UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.jwtProvider = jwtProvider;
    }
    @Bean
    public JwtAuthenticationFilter getJwtAuthenticationFilter(){
      return new JwtAuthenticationFilter(jwtProvider,userDetailsService);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorization!= null && authorization.startsWith(BEARER)){
            final String token = authorization.substring(BEARER.length());
            final String username = jwtProvider.getUserNameFromToken(token);
            ofNullable(userDetailsService.loadUserByUsername(username))
                    .ifPresent(
                            x ->
                                    SecurityContextHolder.getContext().setAuthentication(
                                            new UsernamePasswordAuthenticationToken(
                                                    username,null,x.getAuthorities()
                                            )
                                    )
                    );
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
