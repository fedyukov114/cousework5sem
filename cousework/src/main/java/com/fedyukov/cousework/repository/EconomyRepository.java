package com.fedyukov.cousework.repository;

import com.fedyukov.cousework.entity.Economy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomyRepository extends JpaRepository<Economy, Integer> {
}
