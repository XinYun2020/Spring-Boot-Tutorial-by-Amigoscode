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
	public List<Student> hello() {
	    return List.of(
	        new Student(
	            1L,
	            "Mariam",
	            "mariam.jamal@gmail.com",
	            LocalDate.of(2000,Month.January,5),
	            21
	        )
	    );   // Class will be convered into JSON object
	}

}
