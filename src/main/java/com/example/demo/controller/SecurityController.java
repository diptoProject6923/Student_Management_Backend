package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")

public class SecurityController {


    @Autowired
     private StudentRepository studentRepository;




    @GetMapping("/public")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @GetMapping("/user/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).orElseThrow();
    }


    @PostMapping("/admin")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }


    @PutMapping("/admin/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student s = studentRepository.findById(id).orElseThrow();
        s.setName(student.getName());
        s.setDepartment(student.getDepartment());
        return studentRepository.save(s);
    }


    @DeleteMapping("/admin/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }


}
