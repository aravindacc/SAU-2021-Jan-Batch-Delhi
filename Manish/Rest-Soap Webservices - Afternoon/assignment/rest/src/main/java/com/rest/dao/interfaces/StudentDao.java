package com.rest.dao.interfaces;

import com.rest.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    // create
    int insertStudent(Student student);

    // read
    Optional<Student> selectStudentById(UUID id);

    List<Student> selectAllStudents();

    //update
    int updateStudent(UUID id, Student student);

    // delete
    int deleteStudentById(UUID id);


}
