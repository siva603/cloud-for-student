package com.quiz.student.controller;

import com.quiz.student.LoginDto;
import com.quiz.student.entity.Student;
import com.quiz.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping
    public ResponseEntity<Student> handleSave(@RequestBody Student student)
    {

        return new ResponseEntity<>(service.create(student), HttpStatus.CREATED);
    }

     @PutMapping("/{rollNo}")
    public ResponseEntity<String> handleUpdate(@RequestBody Student student, @PathVariable String rollNo)
    {
        return new ResponseEntity<>(service.update(rollNo,student), HttpStatus.OK);
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<String> handleDelete(@PathVariable String rollNo)
    {
        return new ResponseEntity<>(service.delete(rollNo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> handleGettingAll()
    {
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> handleGettingSingle(@PathVariable String rollNo)
    {
        return new ResponseEntity<>(service.getByRollNO(rollNo), HttpStatus.OK);
    }

    @GetMapping("/group/{group}")
    public ResponseEntity<List<Student>> handleGettingAllByGroup(@PathVariable String group)
    {
        return new ResponseEntity<>(service.getByGroup(group), HttpStatus.OK);
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Student>> handleGettingAllByYear(@PathVariable String year)
    {
        return new ResponseEntity<>(service.getByYear(year), HttpStatus.OK);
    }


    @PutMapping("/admin/update")
    public ResponseEntity<String> handleUpdatePasswordByAdmin(@RequestBody Student student)
    {
        return new ResponseEntity<>(service.updatePasswordAndRollNoByAdmin(student), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Student> handleLogin(@RequestBody LoginDto loginDto)
    {

        if(loginDto!=null){

            return new ResponseEntity<>(service.login(loginDto),HttpStatus.OK);
        }
        return null;
    }
}
