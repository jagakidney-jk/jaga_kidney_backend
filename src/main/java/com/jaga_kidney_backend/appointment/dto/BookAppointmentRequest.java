package com.jaga_kidney_backend.appointment.dto;

import lombok.Data;

@Data
public class BookAppointmentRequest {
    private String machineSeq;
    private String appointmentDate;
    private String location;
    private String slotSeq;
}
