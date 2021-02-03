package edu.ait.winemanager.controllers;

import edu.ait.winemanager.dao.WineDAO;
import edu.ait.winemanager.dto.Wine;
import org.springframework.beans.factory.annotation.Autowired;
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
    WineDAO wineDAO;

    @GetMapping("/wines")
    public List<Wine> getAllWines() {
        return wineDAO.findAll();
    }

    @GetMapping("/wines/{id}")
    public Optional<Wine> getWineById(@PathVariable Integer id) {
        return wineDAO.findById(id);
    }

    @DeleteMapping("/wines/{id}")
    public void deleteWine(@PathVariable Integer id) {
        wineDAO.deleteWine(id);
    }

    @PostMapping("wines/")
    public ResponseEntity createWine(@RequestBody Wine newWine) {

        wineDAO.createWine(newWine);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newWine.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("wines/")
    public ResponseEntity updateWine(@RequestBody Wine newWine) {

        boolean updated = wineDAO.updateWine(newWine);

        if (updated) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("{id}")
                    .buildAndExpand(newWine.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
    }
}
