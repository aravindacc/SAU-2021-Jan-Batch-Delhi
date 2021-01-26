package com.rest.service;

import com.rest.dao.interfaces.StudentDao;
import com.rest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentDao.selectStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int deleteStudentById(UUID id) {
        return studentDao.deleteStudentById(id);
    }

    public int updateStudentById(UUID id, Student student) {
        return studentDao.updateStudent(id, student);
    }

}
