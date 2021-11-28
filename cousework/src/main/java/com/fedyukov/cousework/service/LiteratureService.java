package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.Literature;

import java.util.List;

public interface LiteratureService {
    void create(Literature literature);

    List<Literature> readAll();

    Literature read(int id);

    boolean update(Literature literature, int id);

    boolean delete(int id);
}
