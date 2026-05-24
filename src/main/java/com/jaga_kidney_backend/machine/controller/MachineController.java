package com.jaga_kidney_backend.machine.controller;

import com.jaga_kidney_backend.machine.dto.AddMachineRequest;
import com.jaga_kidney_backend.machine.dto.AddMachineResponse;
import com.jaga_kidney_backend.machine.dto.ChangeMachineStatusRequest;
import com.jaga_kidney_backend.machine.dto.ChangeMachineStatusResponse;
import com.jaga_kidney_backend.machine.dto.RemoveMachineRequest;
import com.jaga_kidney_backend.machine.dto.RemoveMachineResponse;
import com.jaga_kidney_backend.machine.service.MachineService;
import com.jaga_kidney_backend.util.Response;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jagakidney")
@RequiredArgsConstructor
public class MachineController {

    private final MachineService machineService;

    @PostMapping("/add_appointment")
    public Response<AddMachineResponse> addMachine(@RequestHeader("Authorization") String token, @RequestBody AddMachineRequest request) {
        return machineService.addMachine(token, request);
    }

    @PostMapping("/remove_machine")
    public Response<RemoveMachineResponse> removeMachine(@RequestHeader("Authorization") String token, @RequestBody RemoveMachineRequest request) {
        return machineService.removeMachine(token, request);
    }

    @PostMapping("/change_machine_status")
    public Response<ChangeMachineStatusResponse> changeMachineStatus(@RequestHeader("Authorization") String token, @RequestBody ChangeMachineStatusRequest request) {
        return machineService.changeMachineStatus(token, request);
    }

}