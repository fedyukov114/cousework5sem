package com.fedyukov.cousework.controller;

import com.fedyukov.cousework.entity.Literature;
import com.fedyukov.cousework.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LiteratureController {
    private final LiteratureService literatureService;

    @Autowired
    public LiteratureController(LiteratureService literatureService) {
        this.literatureService = literatureService;
    }

    @PostMapping(value = "/literature")
    public ResponseEntity<?> create(@RequestBody Literature literature) {
        literatureService.create(literature);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/literature")
    public ResponseEntity<List<Literature>> read() {
        final List<Literature> literature = literatureService.readAll();

        return literature != null & !literature.isEmpty()
                ? new ResponseEntity<>(literature, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/literature/{id}")
    public ResponseEntity<Literature> read(@PathVariable(name = "id") int id) {
        final Literature literature = literatureService.read(id);

        return literature != null
                ? new ResponseEntity<>(literature, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/literature/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Literature literature) {
        final boolean updated = literatureService.update(literature, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/literature/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = literatureService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
