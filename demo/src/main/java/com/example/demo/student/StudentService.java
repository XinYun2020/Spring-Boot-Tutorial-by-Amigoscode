package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// same as @Component, @Service is for for themantics， 一样的功能看到就知道是Service class
@Service
public class StudentService {


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
