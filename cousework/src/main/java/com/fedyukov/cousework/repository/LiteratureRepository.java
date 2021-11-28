package com.fedyukov.cousework.repository;

import com.fedyukov.cousework.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteratureRepository extends JpaRepository<Literature, Integer> {
}
