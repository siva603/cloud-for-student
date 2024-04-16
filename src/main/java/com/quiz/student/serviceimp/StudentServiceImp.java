package com.quiz.student.serviceimp;

import com.quiz.student.LoginDto;
import com.quiz.student.entity.Student;
import com.quiz.student.repository.StudentRepository;
import com.quiz.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {

        try{
            Student student1 = studentRepository.findByRollNo(student.getRollNo());

            if(student1!=null){
                return student1;
            }
            else{

                return studentRepository.save(student);
            }
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public String update(String rollNO, Student student) {
        try {
            Student student1 = studentRepository.findByRollNo(rollNO);
            if(student1==null)
            {
                return "Student doesn't exist with that rollno";
            }
            student1.setName(student.getName());
            student1.setStudentGroup(student.getStudentGroup());
            student1.setYear(student.getYear());
            student1.setPassword(student.getPassword());
            studentRepository.save(student1);
            return "Student updated successfully";
        }
        catch (Exception e){
            System.out.println(e);
            return "500 server error";
        }
    }

    @Override
    public String delete(String rollNo) {
        try {
            Student student1 = studentRepository.findByRollNo(rollNo);
            if(student1==null)
            {
                return "Student doesn't exist with that rollno";
            }

            studentRepository.deleteById(student1.getId());
            return "Student deleted successfully";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "500 server error";
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getByRollNO(String rollNo) {
        try {
            Student student1 = studentRepository.findByRollNo(rollNo);
            if(student1!=null)
            {
                return student1;
            }
            else{
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Student> getByGroup(String group) {
        try {
            List<Student> student1 = studentRepository.findByStudentGroup(group);
            if(student1!=null)
            {
                return student1;
            }
            else{
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Student> getByYear(String year) {
        try {
            List<Student> student1 = studentRepository.findByYear(year);
            if(student1!=null)
            {
                return student1;
            }
            else{
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }


    @Override
    public String updatePasswordAndRollNoByAdmin(Student student) {
        try {
            Student student1 = studentRepository.findByRollNo(student.getRollNo());
            if(student1==null)
            {
                return "Student doesn't exist with that rollno";
            }
            student1.setName(student.getName());
            student1.setStudentGroup(student.getStudentGroup());
            student1.setYear(student.getYear());
            student1.setPassword(student.getPassword());
            student1.setRole(student.getRole());
            studentRepository.save(student1);
            return "Student updated successfully";
        }
        catch (Exception e){
            System.out.println(e);
            return "500 server error";
        }
    }

    @Override
    public Student login(LoginDto loginDto) {
        try {
            Student student1 = studentRepository.findByRollNo(loginDto.getRollNo());
            if(student1!=null)
            {
                if (student1.getPassword().equals(loginDto.getPassword())) {
                    return student1;
                }

            }
            else{
                return null;
            }
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
        return null;
    }
}
