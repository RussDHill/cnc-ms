package edu.ait.clientdiscovery.controllers;

import edu.ait.winemanager.dto.Wine;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

import java.util.List;

@RestController
public class ClientDiscoveryController {

        @Autowired
        DiscoveryClient discoveryClient;

        @GetMapping("client-discovery/wines/{wineId}")
        public Wine getWineFromWineManager(@PathVariable int wineId) {

                RestTemplate restTemplate = new RestTemplate();

                List<ServiceInstance> serviceInstances = discoveryClient.getInstances("wine-manager");
                ServiceInstance instance = serviceInstances.get(0);

                String serviceUrl = String.format("%s/wines/{wineId}", instance.getUri().toString());
                System.err.println(serviceUrl);

                ResponseEntity<Wine> wineResponseEntity = restTemplate.exchange(serviceUrl,
                        HttpMethod.GET, null, Wine.class, wineId);

                return wineResponseEntity.getBody();
        }

}
