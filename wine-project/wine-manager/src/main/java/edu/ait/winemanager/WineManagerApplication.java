package edu.ait.winemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WineManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WineManagerApplication.class, args);
	}

}
