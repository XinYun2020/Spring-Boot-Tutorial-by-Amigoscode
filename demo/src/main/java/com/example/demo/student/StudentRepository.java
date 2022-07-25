package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Method 1
    @Query("SELECT s From Student s WHERE s.email = ?1")

    // Method 2
    // Transform to SQL like: SELECT * FROM student WHERE email = ?
    Optional<Student> findStudentByEmail(String email); // we can construct the query based on method name
}
