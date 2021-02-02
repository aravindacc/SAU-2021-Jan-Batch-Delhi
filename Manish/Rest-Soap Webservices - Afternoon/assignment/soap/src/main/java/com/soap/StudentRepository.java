package com.soap;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import com.soap.student.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {
        Student s1 = new Student();
        s1.setName("Manish");
        s1.setAge(23);
        students.put(s1.getName(), s1);

        Student s2 = new Student();
        s2.setName("Unknown");
        s2.setAge(20);
    }

    public Student findStudent(String name) {
        Assert.notNull(name, "Student name cant be null");
        return students.get(name);
    }
}