package org.example.service;

import org.example.data.Student;
import org.example.data.dto.StudentDTO;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(StudentDTO studentDTO) {
        studentRepository.save(convertFromDTO(studentDTO));
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private StudentDTO convertToDTO(Student student) {
        return StudentDTO.builder()
                .name(student.getName())
                .semester(student.getSemester())
                .surname(student.getSurname())
                .courseName(student.getCourseName())
                .build();
    }

    private Student convertFromDTO(StudentDTO studentDTO) {
        return Student.builder()
                .name(studentDTO.getName())
                .surname(studentDTO.getSurname())
                .courseName(studentDTO.getCourseName())
                .semester(studentDTO.getSemester())
                .build();
    }
}