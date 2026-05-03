package com.jaga_kidney_backend.security;

import jakarta.servlet.*;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SessionIdFilter implements Filter {

    public static final String SESSION_ID = "sessionId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            String sessionId = UUID.randomUUID().toString();
            MDC.put(SESSION_ID, sessionId);

            chain.doFilter(request, response);

        } finally {
            MDC.clear();
        }
    }
}