package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")        // request mapping path
public class StudentController {
    private final StudentService studentService;

    @Autowired                                  // The studentService should be autowired for us
    public StudentController(StudentService studentService) {
        this.studentService = studentService;   // use dependency injection, avoid using new as much as possible
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudents();    // use the method in StudentService
    }



}

