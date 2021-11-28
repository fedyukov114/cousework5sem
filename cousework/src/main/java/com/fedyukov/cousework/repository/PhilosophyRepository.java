package com.fedyukov.cousework.repository;

import com.fedyukov.cousework.entity.Philosophy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhilosophyRepository extends JpaRepository<Philosophy, Integer> {
}