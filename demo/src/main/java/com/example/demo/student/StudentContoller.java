package com.example.demo.student;

@RestController
@RequestMapping(path = "api/v1/student")    // request mapping path
public class StudentController {
    private final StudentService studentService;

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

