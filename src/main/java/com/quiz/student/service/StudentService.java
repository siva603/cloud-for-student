package com.quiz.student.service;

import com.quiz.student.LoginDto;
import com.quiz.student.entity.Student;

import java.util.List;

public interface StudentService {

    Student create(Student student);
    String update(String rollNo,Student student);

    String delete(String rollNo);

    List<Student> getAllStudents();

    Student getByRollNO(String rollNo);

    List<Student>  getByGroup(String group);

    List<Student>  getByYear(String year);

    String updatePasswordAndRollNoByAdmin(Student student);

    Student login(LoginDto loginDto);
}
