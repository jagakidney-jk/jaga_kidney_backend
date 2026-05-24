package com.jaga_kidney_backend.slot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaga_kidney_backend.security.Jwt;
import com.jaga_kidney_backend.slot.dto.AddSlotRequest;
import com.jaga_kidney_backend.slot.dto.AddSlotResponse;
import com.jaga_kidney_backend.slot.entity.SlotEntity;
import com.jaga_kidney_backend.slot.repository.SlotRepository;
import com.jaga_kidney_backend.util.Response;

@Service
@Transactional
public class SlotService {

    @Autowired
    Jwt jwt;

    @Autowired
    SlotRepository slotRepository;

    public Response<AddSlotResponse> addSlot(String token, AddSlotRequest request) {
        String username = jwt.getUsernameFromToken(token);
        String startTime = request.getStartTime();
        String endTime = request.getEndTime();
        String location = request.getLocation();
        String slotCode = request.getSlotCode();

        SlotEntity slotEntity = new SlotEntity();
        slotEntity.setStartTime(startTime);
        slotEntity.setEndTime(endTime);
        slotEntity.setLocation(location);
        slotEntity.setSlotCode(slotCode);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        slotEntity.setCreatedOn(LocalDateTime.now().format(formatter));
        slotEntity.setCreatedBy(username);

        return Response.success(new AddSlotResponse("Slot Added"));

    }
    
}
