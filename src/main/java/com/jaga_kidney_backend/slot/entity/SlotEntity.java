package com.jaga_kidney_backend.slot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_seq")
    private Integer slotSeq;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "location")
    private String location;

    @Column(name = "slot_code")
    private String slotCode;

    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_on")
    private String updatedOn;

    @Column(name = "updated_by")
    private String updatedBy;
    
}