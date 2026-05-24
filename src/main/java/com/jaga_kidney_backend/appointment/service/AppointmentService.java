package com.jaga_kidney_backend.appointment.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaga_kidney_backend.appointment.dto.BookAppointmentRequest;
import com.jaga_kidney_backend.appointment.dto.BookAppointmentResponse;
import com.jaga_kidney_backend.appointment.dto.CancelAppointmentResponse;
import com.jaga_kidney_backend.appointment.dto.CancelappointmentRequest;
import com.jaga_kidney_backend.appointment.entity.AppointmentEntity;
import com.jaga_kidney_backend.appointment.repository.AppointmentRepository;
import com.jaga_kidney_backend.machine.repository.MachineRepository;
import com.jaga_kidney_backend.security.Jwt;
import com.jaga_kidney_backend.slot.repository.SlotRepository;
import com.jaga_kidney_backend.util.Response;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    Jwt jwt;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    MachineRepository machineRepository;

    @Autowired
    SlotRepository slotRepository;

    public Response<BookAppointmentResponse> bookAppointment(String token, BookAppointmentRequest request) {
        
        int userSeq = jwt.getUserSeqFromToken(token.substring(7));
        int machineSeq = Integer.parseInt(request.getMachineSeq());
        String appointmentDate = request.getAppointmentDate();
        String location = request.getLocation();
        int slotSeq = Integer.parseInt(request.getSlotSeq());

        AppointmentEntity bookAppointmentEntity = new AppointmentEntity();
        bookAppointmentEntity.setUserSeq(userSeq);
        bookAppointmentEntity.setMachineSeq(machineSeq);
        bookAppointmentEntity.setAppointmentDate(appointmentDate);
        bookAppointmentEntity.setLocation(location);
        bookAppointmentEntity.setSlotSeq(slotSeq);
        bookAppointmentEntity.setStatus("Booked");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        bookAppointmentEntity.setCreatedOn(LocalDateTime.now().format(formatter));

        appointmentRepository.save(bookAppointmentEntity);
        machineRepository.updateStatus(machineSeq, "Booked");

        return Response.success(new BookAppointmentResponse("Booked"));

    }

    public Response<CancelAppointmentResponse> cancelAppointment(String token, CancelappointmentRequest request) {
        
        return Response.success(new CancelAppointmentResponse("Canceled"));

    }
    
}
