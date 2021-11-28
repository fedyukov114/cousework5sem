package com.fedyukov.cousework.controller;

import com.fedyukov.cousework.entity.Philosophy;
import com.fedyukov.cousework.service.PhilosophyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhilosophyController {
    private final PhilosophyService philosophyService;

    @Autowired
    public PhilosophyController(PhilosophyService philosophyService){
        this.philosophyService = philosophyService;
    }

    @PostMapping(value = "/philosophy")
    public ResponseEntity<?> create(@RequestBody Philosophy philosophy) {
        philosophyService.create(philosophy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/philosophy")
    public ResponseEntity<List<Philosophy>> read() {
        final List<Philosophy> philosophy = philosophyService.readAll();

        return philosophy != null & !philosophy.isEmpty()
                ? new ResponseEntity<>(philosophy, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/philosophy/{id}")
    public ResponseEntity<Philosophy> read(@PathVariable(name = "id") int id) {
        final Philosophy philosophy = philosophyService.read(id);

        return philosophy != null
                ? new ResponseEntity<>(philosophy, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/philosophy/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Philosophy philosophy) {
        final boolean updated = philosophyService.update(philosophy, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/philosophy/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = philosophyService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
