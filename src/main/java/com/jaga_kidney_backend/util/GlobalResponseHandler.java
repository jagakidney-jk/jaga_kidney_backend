package com.jaga_kidney_backend.util;

import org.springframework.core.MethodParameter;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                 MethodParameter returnType,
                                 MediaType selectedContentType,
                                 Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                 org.springframework.http.server.ServerHttpRequest request,
                                 org.springframework.http.server.ServerHttpResponse response) {

        if (body instanceof Response<?> res) {
            response.setStatusCode(HttpStatus.valueOf(res.getStatus())); // 🔥 THIS FIXES 403
            return res;
        }

        return body;
    }
}