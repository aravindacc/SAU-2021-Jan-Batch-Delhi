package com.rest.controller;

import com.rest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rest.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rest/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public int addPerson(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping(path = "{id}")
    public Optional<Student> getStudentById(@PathVariable UUID id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PutMapping(path = "{id}")
    public int updateStudentById(@PathVariable UUID id, @RequestBody @Valid Student student) {
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping(path = "{id}")
    public int deleteStudentById(@PathVariable UUID id) {
        return studentService.deleteStudentById(id);
    }
}
