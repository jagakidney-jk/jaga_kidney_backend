package com.jaga_kidney_backend.slot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaga_kidney_backend.slot.entity.SlotEntity;

@Repository
public interface SlotRepository extends JpaRepository<SlotEntity, Integer> {
    
}
