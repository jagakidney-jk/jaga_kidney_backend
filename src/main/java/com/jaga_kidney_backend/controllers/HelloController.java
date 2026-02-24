package com.jaga_kidney_backend.controllers;

import com.jaga_kidney_backend.payload.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public ApiResponse<String> hello(){
    return ApiResponse.success("Hello");
  }
}
