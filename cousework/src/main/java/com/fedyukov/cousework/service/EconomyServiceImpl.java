package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.Economy;
import com.fedyukov.cousework.repository.EconomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EconomyServiceImpl implements EconomyService{

    @Autowired
    private EconomyRepository economyRepository;

    @Override
    public void create(Economy economy) {
        economyRepository.save(economy);
    }

    @Override
    public List<Economy> readAll() {
        return economyRepository.findAll();
    }

    @Override
    public Economy read(int id) {
        return economyRepository.getOne(id);
    }

    @Override
    public boolean update(Economy economy, int id) {
        if (economyRepository.existsById(id)) {
            economy.setScorebookNumber(id);
            economyRepository.save(economy);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (economyRepository.existsById(id)) {
            economyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
