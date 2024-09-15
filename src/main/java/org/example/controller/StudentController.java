package org.example.controller;

import org.example.data.dto.StudentDTO;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> getStudent() {
        return studentService.getAllStudents();
    }
}