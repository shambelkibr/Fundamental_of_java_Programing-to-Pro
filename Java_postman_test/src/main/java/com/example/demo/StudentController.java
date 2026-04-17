package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // POST create new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // PUT update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
}
