package com.spring.authorization.controller;

import com.spring.authorization.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private List<Student> studentList = new ArrayList<>(List.of(
            new Student("001", "Mike", "2.52"),
            new Student("002", "Mel", "5.52"),
            new Student("003", "Sam", "3.52")
    ));

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        log.info("Student List -> {}", studentList);
        return studentList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }
}
