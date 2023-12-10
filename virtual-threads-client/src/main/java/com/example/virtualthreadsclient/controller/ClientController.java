package com.example.virtualthreadsclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClientController {
	
	private final RestClient restClient;

	public ClientController(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("http://localhost:8081").build();
	}

	@GetMapping("/api/block/{seconds}")
	public String block(@PathVariable Integer seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
		log.info("Blocked for {} seconds ", seconds);
		ResponseEntity<Void> result =  restClient.get()
				  .uri("/api/block/"+seconds)
				  .retrieve()
				  .toBodilessEntity();
		log.info("{} on {}", result.getStatusCode(), Thread.currentThread());
		return Thread.currentThread().toString();
	}

}
