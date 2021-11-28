package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.Literature;
import com.fedyukov.cousework.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteratureServiceImpl implements LiteratureService{
    @Autowired
    private LiteratureRepository literatureRepository;

    @Override
    public void create(Literature literature) {
        literatureRepository.save(literature);
    }

    @Override
    public List<Literature> readAll() {
        return literatureRepository.findAll();
    }

    @Override
    public Literature read(int id) {
        return literatureRepository.getOne(id);
    }

    @Override
    public boolean update(Literature literature, int id) {
        if(literatureRepository.existsById(id)) {
            literature.setScorebookNumber(id);
            literatureRepository.save(literature);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (literatureRepository.existsById(id)) {
            literatureRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
