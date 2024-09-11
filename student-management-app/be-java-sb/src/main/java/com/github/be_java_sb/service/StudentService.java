package com.github.be_java_sb.service;

import com.github.be_java_sb.entity.Student;
import com.github.be_java_sb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    // Get all Students
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        if (students.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No students found");
        }

        return students;
    }

    // Get a Student by ID
    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
    }

    // Add a Student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update a Student by ID
    public Student updateStudent(int id, Student student) {
        Student updatedStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        if (student.getName() != null) {
            updatedStudent.setName(student.getName());
        }
        if (student.getAge() != 0) {  // assuming age 0 means not provided
            updatedStudent.setAge(student.getAge());
        }
        if (student.getDept() != null) {
            updatedStudent.setDept(student.getDept());
        }

        return studentRepository.save(updatedStudent);
    }

    // Delete a Student by ID
    public boolean deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
    }

}
