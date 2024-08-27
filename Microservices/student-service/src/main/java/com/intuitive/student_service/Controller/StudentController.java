package com.intuitive.student_service.Controller;

import com.intuitive.student_service.Entity.Student;
import com.intuitive.student_service.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private studentService studentService;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllstudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>fetchStudentById(@PathVariable int id){
        return studentService.fetchStudentById(id);
    }


}
