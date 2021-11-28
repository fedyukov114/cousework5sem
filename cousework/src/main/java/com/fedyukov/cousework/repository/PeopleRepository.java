package com.fedyukov.cousework.repository;

import com.fedyukov.cousework.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
