package edu.ait.clientfeign.feignclients;

import edu.ait.winemanager.dto.Wine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient("wine-manager")
public interface WineManagerClient {

    @GetMapping("/wines")
    List<Wine> getWines();

    @GetMapping("/wines/{id}")
    Wine getWineById(@PathVariable Integer id);
}
