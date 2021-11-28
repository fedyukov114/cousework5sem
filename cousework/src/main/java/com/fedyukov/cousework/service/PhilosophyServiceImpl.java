package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.Philosophy;
import com.fedyukov.cousework.repository.PhilosophyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhilosophyServiceImpl implements PhilosophyService{

    @Autowired
    private PhilosophyRepository philosophyRepository;

    @Override
    public void create(Philosophy philosophy) {
        philosophyRepository.save(philosophy);
    }

    @Override
    public List<Philosophy> readAll() {
        return philosophyRepository.findAll();
    }

    @Override
    public Philosophy read(int id) {
        return philosophyRepository.getOne(id);
    }

    @Override
    public boolean update(Philosophy philosophy, int id) {
        if (philosophyRepository.existsById(id)) {
            philosophy.setScorebookNumber(id);
            philosophyRepository.save(philosophy);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (philosophyRepository.existsById(id)) {
            philosophyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
