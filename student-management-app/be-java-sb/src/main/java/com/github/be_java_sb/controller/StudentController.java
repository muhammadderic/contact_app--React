package com.github.be_java_sb.controller;

import com.github.be_java_sb.entity.Student;
import com.github.be_java_sb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentService studentService;

    // Get all Students
    @GetMapping("/students")
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a Student by ID
    @GetMapping("/students/{id}")
    public Student fetchStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    // Add a Student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Update a Student by ID
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Delete a Student by ID
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudentController(@PathVariable int id) {
        try {
            if (studentService.deleteStudent(id)) {
                return ResponseEntity.noContent().build(); // 204 No Content
            } else {
                return ResponseEntity.notFound().build(); // 404 Not Found
            }
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(null); // Forward the exception status
        }
    }

}
