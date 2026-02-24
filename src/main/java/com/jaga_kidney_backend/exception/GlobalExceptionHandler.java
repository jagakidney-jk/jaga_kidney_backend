package com.jaga_kidney_backend.exception;

import com.jaga_kidney_backend.payload.ApiResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleResourceNotFound(
      ResourceNotFoundException ex)
  {

    ApiResponse<?> response =
        ApiResponse.error(ex.getMessage(), "RESOURCE_NOT_FOUND");

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<ApiResponse<?>> handleConflict(
      ConflictException ex)
  {

    ApiResponse<?> response =
        ApiResponse.error(ex.getMessage(), "CONFLICT");

    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }


  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<ApiResponse<?>> handleUnauthorized(
      UnauthorizedException ex)
  {

    ApiResponse<?> response =
        ApiResponse.error(ex.getMessage(), "UNAUTHORIZED");

    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
  }


  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ApiResponse<?>> handleBadRequest(
      BadRequestException ex)
  {

    ApiResponse<?> response =
        ApiResponse.error(ex.getMessage(), "BAD_REQUEST");

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidation(
      MethodArgumentNotValidException ex)
  {

    List<String> errors =
        ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error ->
                error.getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.toList());

    ErrorResponse response =
        ErrorResponse.builder()
            .message("Validation failed")
            .errorCode("VALIDATION_ERROR")
            .status(HttpStatus.BAD_REQUEST.value())
            .details(errors)
            .timestamp(LocalDateTime.now())
            .build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<?>> handleGlobalException(
      Exception ex)
  {

    ApiResponse<?> response =
        ApiResponse.error(
            "Something went wrong. Please try again.",
            "INTERNAL_SERVER_ERROR");

    return new ResponseEntity<>(response,
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
