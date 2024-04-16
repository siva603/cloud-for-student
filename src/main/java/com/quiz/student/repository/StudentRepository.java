package com.quiz.student.repository;

import com.quiz.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByRollNo(String rollNo);

    List<Student> findByYear(String year);

    List<Student> findByStudentGroup(String group);
}
