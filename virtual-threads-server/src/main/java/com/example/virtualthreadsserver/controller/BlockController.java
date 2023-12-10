package com.example.virtualthreadsserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BlockController {

	@GetMapping("/api/block/{seconds}")
	public void block(@PathVariable Integer seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
		log.info("Blocked for {} seconds ", seconds);
	}

}
