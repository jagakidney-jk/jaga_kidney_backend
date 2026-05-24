package com.jaga_kidney_backend.machine.dto;

import lombok.Data;

@Data
public class AddMachineRequest {
    private String startTime;
    private String endTime;
    private String location;
    private String slotCode;
}
