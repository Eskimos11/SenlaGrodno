package com.senla.security;

import com.senla.api.dao.UserDao;
import com.senla.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final UserDao userDao;

    public JwtAuthenticationFilter(JwtProvider jwtProvider, UserDetailsService userDetailsService, UserDao userDao) {
        this.userDetailsService = userDetailsService;
        this.jwtProvider = jwtProvider;
        this.userDao = userDao;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, @NonNull HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorization!= null && authorization.startsWith(BEARER)){
            final String token = authorization.substring(BEARER.length());
            final String username = jwtProvider.getUserNameFromToken(token);
            com.senla.entity.User user = userDao.getByName(username);
            ofNullable(userDetailsService.loadUserByUsername(username))
                    .ifPresent(x -> SecurityContextHolder.getContext().setAuthentication(
                                            new UsernamePasswordAuthenticationToken(
                                                    user.getId(),null,x.getAuthorities()
                                            )
                                    )
                    );
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
