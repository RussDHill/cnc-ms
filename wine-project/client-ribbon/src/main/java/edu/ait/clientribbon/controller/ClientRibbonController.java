package edu.ait.clientribbon.controller;

import edu.ait.winemanager.dto.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientRibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("client-ribbon/wines/{wineId}")
    public Wine getWineFromWineManager(@PathVariable int wineId) {

        ResponseEntity<Wine> wineResponseEntity = restTemplate.exchange("http://wine-manager/wines/{wineId}",
                HttpMethod.GET, null, Wine.class, wineId);

        return wineResponseEntity.getBody();
    }
}
