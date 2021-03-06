package edu.ait.clientfeign.controllers;

import edu.ait.clientfeign.feignclients.WineManagerClient;
import edu.ait.winemanager.dto.Wine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class ClientFeignController {

    @Autowired
    WineManagerClient wineManagerClient;

    @GetMapping("client-feign/wines")
    public List<Wine> getWinesFromWineManager() {
        return wineManagerClient.getWines();
    }

    @GetMapping("client-feign/wines/{wineId}")
    public Wine getWineFromWineManager(@PathVariable int wineId) {
        return wineManagerClient.getWineById(wineId);
    }
}
