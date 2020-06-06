package com.li.back.controller;

import com.li.back.dto.StudentGetDto;
import com.li.back.dto.StudentPostDto;

import com.li.back.entity.Student;
import com.li.back.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController

public class StudentAddController {

    @Autowired
    private StudentService studentService;


    @PostMapping(
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentGetDto> addStudent(@RequestBody StudentPostDto studentPostDto){
        return ResponseEntity.ok(studentService.addStudent(studentPostDto));
    }

    @DeleteMapping(
            value = "/deleteById/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
    @GetMapping(
            value = "/find",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @PutMapping("/update")
    public void updateStudent(@RequestBody StudentPostDto studentPostDto){
        studentService.updateStudent(studentPostDto);
    }
}








