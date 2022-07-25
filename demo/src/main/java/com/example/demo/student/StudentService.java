package com.example.demo.student;

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
