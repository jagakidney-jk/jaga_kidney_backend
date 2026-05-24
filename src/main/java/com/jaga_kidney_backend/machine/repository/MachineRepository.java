package com.jaga_kidney_backend.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaga_kidney_backend.machine.entity.MachineEntity;

@Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Integer> {

    @Modifying
    @Query(value = "UPDATE machines SET status = ?2 WHERE machine_seq = ?1", nativeQuery = true)
    int updateStatus(Integer machine_seq, String status);
    
}
