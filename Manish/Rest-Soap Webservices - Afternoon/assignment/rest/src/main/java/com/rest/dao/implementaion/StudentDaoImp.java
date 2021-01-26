package com.rest.dao.implementaion;

import com.rest.dao.interfaces.StudentDao;
import com.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDaoImp implements StudentDao {

    // acting as app database
    Map<UUID, Student> database = new HashMap<>();

    @Override
    public int insertStudent(Student student) {
        database.put(student.getId(), student);
        return 1;
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        Student student = database.getOrDefault(id, null);
        return student == null ? Optional.empty() : Optional.of(student);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudent(UUID id, Student student) {

        if (database.containsKey(id)) {
            student.setId(id);
            database.put(id, student);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteStudentById(UUID id) {
        if (database.containsKey(id)) {
            database.remove(id);
            return 1;
        }
        return 0;
    }
}
