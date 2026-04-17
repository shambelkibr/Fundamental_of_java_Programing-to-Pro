package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // GET all students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // POST create a new student
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    // PUT update a student
    public Student updateStudent(Long id, Student updatedStudent) {
        return repository.findById(id).map(student -> {
            student.setFirstname(updatedStudent.getFirstname());
            student.setLastname(updatedStudent.getLastname());
            student.setEmail(updatedStudent.getEmail());
            return repository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // DELETE student
    public String deleteStudent(Long id) {
        repository.deleteById(id);
        return "Student deleted with id " + id;
    }
}
