package edu.ait.winemanager.controllers;

import edu.ait.winemanager.exceptions.WineNotFoundException;
import edu.ait.winemanager.repositories.WineRepository;
import edu.ait.winemanager.dto.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class WineController {

    @Autowired
    WineRepository wineRepository;

    @GetMapping("/wines")
    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    @GetMapping("/wines/{id}")
    public Optional<Wine> getWineById(@PathVariable Integer id) {
        return wineRepository.findById(id);
    }

    @DeleteMapping("/wines/{id}")
    public void deleteWine(@PathVariable Integer id) {
        try {
            wineRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new WineNotFoundException("Unable to delete wine with id: " + id);
        }
    }

    @PostMapping("wines/")
    public ResponseEntity createWine(@RequestBody Wine newWine) {

        wineRepository.save(newWine);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newWine.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("wines/")
    public ResponseEntity updateWine(@RequestBody Wine newWine) {

        if (newWine.getId() != null) {
            wineRepository.save(newWine);

            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            Wine savedWine = wineRepository.save(newWine);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(savedWine.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
    }
}
