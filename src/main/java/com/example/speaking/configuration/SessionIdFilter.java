package com.example.speaking.configuration;

import com.example.speaking.model.entity.PersonSession;
import com.example.speaking.repository.PersonSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SessionIdFilter extends OncePerRequestFilter {

    @Autowired
    private PersonSessionRepository personSessionRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String header = httpServletRequest.getHeader("Authorization");
        if(header != null){
            PersonSession personSession =  personSessionRepository
                    .findBySessionIdAndIsValidTrue(header);
            if(personSession != null){
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(
                                personSession.getPerson(),
                                null,
                                new ArrayList<>()
                        );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
