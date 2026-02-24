package com.jaga_kidney_backend.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T>
{

  private boolean success;

  private String message;

  private T data;

  private LocalDateTime timestamp;

  private String errorCode;

  public static <T> ApiResponse<T> success(T data, String message)
  {
    return ApiResponse.<T>builder()
        .success(true)
        .message(message)
        .data(data)
        .timestamp(LocalDateTime.now())
        .build();
  }


  public static <T> ApiResponse<T> success(T data)
  {
    return success(data, "Request successful");
  }

  public static ApiResponse<?> error(String message, String errorCode)
  {
    return ApiResponse.builder()
        .success(false)
        .message(message)
        .errorCode(errorCode)
        .timestamp(LocalDateTime.now())
        .build();
  }

}
