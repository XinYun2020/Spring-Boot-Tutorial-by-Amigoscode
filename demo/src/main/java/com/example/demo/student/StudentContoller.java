package com.example.demo.student;

@RestController
@RequestMapping(path = "api/v1/student")    // request mapping path
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudents();    // use the method in StudentService
    }



}

