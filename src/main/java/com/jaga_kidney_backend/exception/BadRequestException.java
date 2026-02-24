package com.jaga_kidney_backend.exception;

public class BadRequestException extends RuntimeException
{

  public BadRequestException(String message)
  {
    super(message);
  }

}
