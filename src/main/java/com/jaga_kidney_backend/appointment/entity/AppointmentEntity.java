package com.jaga_kidney_backend.appointment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_seq")
    private Integer appointmentSeq;

    @Column(name = "user_seq")
    private Integer userSeq;

    @Column(name = "machine_seq")
    private Integer machineSeq;

    @Column(name = "appointment_date")
    private String appointmentDate;

    @Column(name = "location")
    private String location;

    @Column(name = "slot_seq")
    private Integer slotSeq;

    @Column(name = "status")
    private String status;

    @Column(name = "created_on")
    private String createdOn;
}