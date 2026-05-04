package com.jaga_kidney_backend.security;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtFilter;

        @Value("${allowed_endpoints}")
        private String allowed_endpoints;

        private String[] getAllowedUrls() {
                return Arrays.stream(allowed_endpoints.split(","))
                                .map(String::trim)
                                .map(e -> "/jagakidney" + e)
                                .toArray(String[]::new);
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                return http
                                .csrf(csrf -> csrf.disable())

                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(getAllowedUrls()).permitAll()
                                                .anyRequest().authenticated())

                                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                                // JWT filter runs after MDC filter automatically
                                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                                .build();
        }
}