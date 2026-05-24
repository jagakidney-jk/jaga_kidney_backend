package com.jaga_kidney_backend.slot.dto;

import lombok.Data;

@Data
public class AddSlotRequest {
    private String startTime;
    private String endTime;
    private String location;
    private String slotCode;
}
