package com.github.be_java_sb.repository;

import com.github.be_java_sb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
