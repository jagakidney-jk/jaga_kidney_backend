package com.jaga_kidney_backend.exception;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse
{

  private String message;

  private String errorCode;

  private int status;

  private LocalDateTime timestamp;

  private List<String> details;

}
