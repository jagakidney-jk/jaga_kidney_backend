package com.jaga_kidney_backend.util;

import org.slf4j.MDC;

public class Response<T> {

    private int status;
    private String sessionId;
    private T data;

    public Response() {}

    public int getStatus() { return status; }
    public String getSessionId() { return sessionId; }
    public T getData() { return data; }

    public static <T> Response<T> builder() {
        return new Response<>();
    }

    public Response<T> status(int status) {
        this.status = status;
        return this;
    }

    public Response<T> sessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Response<T> data(T data) {
        this.data = data;
        return this;
    }

    public Response<T> build() {
        return this;
    }

    private static String resolveSessionId() {
        return MDC.get("sessionId");
    }

    public static <T> Response<T> success(T data) {
        return Response.<T>builder()
                .status(200)
                .sessionId(resolveSessionId())
                .data(data)
                .build();
    }

    public static <T> Response<T> error(int status) {
        return Response.<T>builder()
                .status(status)
                .sessionId(resolveSessionId())
                .data(null)
                .build();
    }
}