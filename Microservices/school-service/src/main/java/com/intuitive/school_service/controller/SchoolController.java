package com.intuitive.school_service.controller;


import com.intuitive.school_service.Entity.School;
import com.intuitive.school_service.Service.schoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {

    @Autowired
    private schoolService schoolService;

    @GetMapping
    public List<School> getAllSchool(){
        return schoolService.getALLSchools();
    }
    @GetMapping("/{id}")
    public ResponseEntity<School>getschoolById(@PathVariable int id){
        School school = schoolService.getSchoolByID(id);
        return school != null? ResponseEntity.ok(school):ResponseEntity.notFound().build();
    }

}
