package com.jaga_kidney_backend.machine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaga_kidney_backend.machine.dto.AddMachineRequest;
import com.jaga_kidney_backend.machine.dto.AddMachineResponse;
import com.jaga_kidney_backend.machine.dto.ChangeMachineStatusRequest;
import com.jaga_kidney_backend.machine.dto.ChangeMachineStatusResponse;
import com.jaga_kidney_backend.machine.dto.RemoveMachineRequest;
import com.jaga_kidney_backend.machine.dto.RemoveMachineResponse;
import com.jaga_kidney_backend.security.Jwt;
import com.jaga_kidney_backend.util.Response;

@Service
@Transactional
public class MachineService {

    @Autowired
    Jwt jwt;

    public Response<AddMachineResponse> addMachine(String token, AddMachineRequest request) {
        
        return Response.success(new AddMachineResponse("Booked"));

    }

    public Response<RemoveMachineResponse> removeMachine(String token, RemoveMachineRequest request) {
        
        return Response.success(new RemoveMachineResponse("Canceled"));

    }

    public Response<ChangeMachineStatusResponse> changeMachineStatus(String token, ChangeMachineStatusRequest request) {
        
        return Response.success(new ChangeMachineStatusResponse("Changed"));

    }
    
}
