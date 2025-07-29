package com.spring.authorization.controller;

import com.spring.authorization.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> studentList = new ArrayList<>(List.of(
            new Student("001", "Mike", 2.52),
            new Student("002", "Mel", 5.52),
            new Student("003", "Sam", 3.52)
    ));

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentList;
    }
}
