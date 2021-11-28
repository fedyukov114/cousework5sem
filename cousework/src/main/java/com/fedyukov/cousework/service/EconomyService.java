package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.Economy;

import java.util.List;

public interface EconomyService {
    void create(Economy economy);

    List<Economy> readAll();

    Economy read(int id);

    boolean update(Economy economy, int id);

    boolean delete(int id);
}
