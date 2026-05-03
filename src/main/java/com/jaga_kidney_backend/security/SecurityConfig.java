// package com.jaga_kidney_backend.security;

// import lombok.RequiredArgsConstructor;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.*;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @RequiredArgsConstructor
// public class SecurityConfig {

//     @Autowired
//     private JwtAuthenticationFilter jwtFilter;

//     @Value("${allowed_endpoints}")
//     private String allowed_endpoints;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         return http
//                 .csrf(csrf -> csrf.disable())

//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/jagakidney/auth"+allowed_endpoints).permitAll()
//                         .anyRequest().authenticated()
//                 )

//                 .sessionManagement(sess ->
//                         sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                 )

//                 .addFilterBefore(jwtFilter,
//                         UsernamePasswordAuthenticationFilter.class)

//                 .build();
//     }
// }

package com.jaga_kidney_backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/jagakidney/auth/login").permitAll()
                        .anyRequest().authenticated()
                )

                .sessionManagement(sess ->
                        sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // JWT filter runs after MDC filter automatically
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }
}