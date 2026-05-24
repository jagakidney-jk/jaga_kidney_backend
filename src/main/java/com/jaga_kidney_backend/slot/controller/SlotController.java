package com.jaga_kidney_backend.slot.controller;

import com.jaga_kidney_backend.slot.dto.AddSlotRequest;
import com.jaga_kidney_backend.slot.dto.AddSlotResponse;
import com.jaga_kidney_backend.slot.service.SlotService;
import com.jaga_kidney_backend.util.Response;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jagakidney")
@RequiredArgsConstructor
public class SlotController {

    private final SlotService slotService;

    @PostMapping("/add_slot")
    public Response<AddSlotResponse> addSlot( @RequestHeader("Authorization") String token, @RequestBody AddSlotRequest request) {
        return slotService.addSlot(token, request);
    }

}