package com.example.demo.student;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

  private static final List<Student> STUDENT = Arrays.asList(
      new Student(1, "John Travolta"),
      new Student(2, "Chuck Norris"),
      new Student(3, "Nicolas Cage")
  );

  @GetMapping(path = "{studentId}")
  public Student getStudent(@PathVariable("studentId") Integer studentId) {
    return STUDENT.stream().filter(student -> studentId.equals(student.getStudentId())).findFirst()
        .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exists"));
  }

}
