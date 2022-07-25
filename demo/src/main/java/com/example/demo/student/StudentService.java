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
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(); // all avaliable method (Spring Data JPA)
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " dose not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    // we are not using any queries
    // @Transactional => the entity goes into management state (JDA)
    public void updateStudent(Long studentId, String name, String email) {
        // checking if student exists
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                    "Student Id " + studentId + " does not exists. "));

        // name guard
        if(name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        // email guard
        if(email != null &&
            email.length() > 0  &&
            !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional =
                    studentRepository.findStudentByEmail(email);

        // check if the email been taken
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        student.setEmail(email);
        }
    }
}
