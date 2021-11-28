package com.fedyukov.cousework.controller;

import com.fedyukov.cousework.entity.Economy;
import com.fedyukov.cousework.service.EconomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EconomyController {
    private final EconomyService economyService;

    @Autowired
    public EconomyController(EconomyService economyService){
        this.economyService = economyService;
    }

    @PostMapping(value = "/economy")
    public ResponseEntity<?> create(@RequestBody Economy economy) {
        economyService.create(economy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/economy")
    public ResponseEntity<List<Economy>> read() {
        final List<Economy> economy = economyService.readAll();

        return economy != null & !economy.isEmpty()
                ? new ResponseEntity<>(economy, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/economy/{id}")
    public ResponseEntity<Economy> read(@PathVariable(name = "id") int id) {
        final Economy economy = economyService.read(id);

        return economy != null
                ? new ResponseEntity<>(economy, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/economy/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Economy economy) {
        final boolean updated = economyService.update(economy, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/economy/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = economyService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}