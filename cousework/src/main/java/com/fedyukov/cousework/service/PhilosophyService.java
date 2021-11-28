package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.Philosophy;

import java.util.List;

public interface PhilosophyService {
    void create(Philosophy philosophy);

    List<Philosophy> readAll();

    Philosophy read(int id);

    boolean update(Philosophy philosophy, int id);

    boolean delete(int id);
}
