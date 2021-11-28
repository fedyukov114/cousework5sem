package com.fedyukov.cousework.service;

import com.fedyukov.cousework.entity.People;
import com.fedyukov.cousework.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService{

    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    @Override
    public void create(People people) {
        peopleRepository.save(people);
    }

    @Override
    public List<People> readAll() {
        return peopleRepository.findAll();
    }

    @Override
    public People read(int id) {
        return peopleRepository.getOne(id);
    }

    @Override
    public boolean update(People people, int id) {
        if (peopleRepository.existsById(id)) {
            people.setScorebookNumber(id);
            peopleRepository.save(people);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (peopleRepository.existsById(id)) {
            peopleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
