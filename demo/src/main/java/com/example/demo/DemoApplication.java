package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController     // make this class to serve restful endpoints
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    // Get sth out of our server
    // current rest endpoint
	@GetMapping
	public List<String> hello() {
	    return List.of("Hello", "World");   // will receive JSON back
	}

}
