package com.fedyukov.cousework.controller;

import com.fedyukov.cousework.entity.People;
import com.fedyukov.cousework.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    // Реализация методов для обработки CRUD операций

    // Post метод
    @PostMapping(value = "/people")
    public ResponseEntity<?> create(@RequestBody People people) {
        peopleService.create(people);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Get метод для вывода всех студентов
    @GetMapping(value = "/people")
    public ResponseEntity<List<People>> read() {
        final List<People> people = peopleService.readAll();

        return people != null && !people.isEmpty()
                ? new ResponseEntity<>(people, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get метод для вывода определенного студента
    @GetMapping(value = "/people/{id}")
    public ResponseEntity<People> read(@PathVariable(name = "id") int id) {
        final People people = peopleService.read(id);

        return  people != null
                ? new ResponseEntity<>(people, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // Put метод
    @PutMapping(value = "/people/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody People people) {
        final boolean updated = peopleService.update(people, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Delete метод
    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = peopleService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
