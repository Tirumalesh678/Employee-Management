package com.example.backend.controller;

import com.example.backend.entity.Student;
import com.example.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> findAll()
    {
        return studentService.getAllStudents();
    }
    @GetMapping("/student/{id}")
    public Student findById(@PathVariable("id") Long id)
    {
        return studentService.findById(id);
    }
    @GetMapping("/student/name")
    public Student getByName(@RequestParam("name") String name)
    {
        return studentService.findByName(name);
    }
    @PostMapping("/student")
    public void save(@RequestBody Student student)
    {
        studentService.saveStudent(student);
    }
    @PutMapping("student/{id}")
    public void updateStudent(@PathVariable("id") Long id,@RequestBody Student student)
    {
        studentService.updateStudent(student,id);
    }
}
