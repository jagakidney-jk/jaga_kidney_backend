package com.jaga_kidney_backend.appointment.controller;

import com.jaga_kidney_backend.appointment.dto.BookAppointmentRequest;
import com.jaga_kidney_backend.appointment.dto.BookAppointmentResponse;
import com.jaga_kidney_backend.appointment.dto.CancelAppointmentResponse;
import com.jaga_kidney_backend.appointment.dto.CancelappointmentRequest;
import com.jaga_kidney_backend.appointment.service.AppointmentService;
import com.jaga_kidney_backend.util.Response;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jagakidney")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService bookAppointmentService;

    @PostMapping("/book_appointment")
    public Response<BookAppointmentResponse> bookAppointment( @RequestHeader("Authorization") String token, @RequestBody BookAppointmentRequest request) {
        return bookAppointmentService.bookAppointment(token, request);
    }

    @PostMapping("/cancel_appointment")
    public Response<CancelAppointmentResponse> cancelAppointment( @RequestHeader("Authorization") String token, @RequestBody CancelappointmentRequest request) {
        return bookAppointmentService.cancelAppointment(token, request);
    }
}