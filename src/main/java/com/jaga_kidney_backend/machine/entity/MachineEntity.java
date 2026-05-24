package com.jaga_kidney_backend.machine.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "machines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_seq")
    private Integer machineSeq;

    @Column(name = "machine_code")
    private String machineCode;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Column(name = "created_on")
    private String createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_on")
    private String updatedOn;

    @Column(name = "updated_by")
    private String updatedBy;
    
}