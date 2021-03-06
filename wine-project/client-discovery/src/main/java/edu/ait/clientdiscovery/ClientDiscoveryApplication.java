package edu.ait.clientdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientDiscoveryApplication.class, args);
	}

}
