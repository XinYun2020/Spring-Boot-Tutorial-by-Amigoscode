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

    @PostMapping    // Actions for URL => Open in HTTP client => generated-requests.http
    public void registerNewStudent(@RequestBody Student student) {  // take the requestbody and map to a student
        studentService.addNewStudent(student);  // invoke service => press option+enter to create a method inside of Service Class
    }

    @DeleteMapping(path = "{studentId}")        // with path of studentId
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}

