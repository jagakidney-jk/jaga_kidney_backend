package com.jaga_kidney_backend.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private Jwt jwt;
    
    @Value("${allowed_endpoints}")
    private String allowed_endpoints;

    private boolean isAllowedEndpoint(String path) {
        String[] endpoints = allowed_endpoints.split(",");

        for (String endpoint : endpoints) {
            endpoint = endpoint.trim();

            // match exact or wildcard
            if (path.equals("/jagakidney" + endpoint)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        // allow login
        if (isAllowedEndpoint(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        if (jwt.validateToken(token)) {

            String username = jwt.getUsernameFromToken(token);

            if (SecurityContextHolder.getContext().getAuthentication() == null) {

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                new User(username, "", Collections.emptyList()),
                                null,
                                Collections.emptyList()
                        );

                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
}