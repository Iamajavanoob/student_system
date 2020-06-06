package com.li.back.service;

import com.li.back.dto.StudentGetDto;
import com.li.back.dto.StudentPostDto;
import com.li.back.entity.Student;
import com.li.back.repository.StudentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Random;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @SneakyThrows

    public Collection<Student> findAll(){
        return studentRepository.findAll();
    }

    public StudentGetDto addStudent(StudentPostDto studentPostDto){
        Student student = new Student();
        student.setName(studentPostDto.getName());
        student.setAge(studentPostDto.getAge());
        student.setId(new Random().nextLong());

        Student studentFromDB = studentRepository.save(student);

        StudentGetDto studentGetDto = new StudentGetDto();
        studentGetDto.setAge(studentFromDB.getAge());
        studentGetDto.setName(studentFromDB.getName());
        studentGetDto.setId(studentFromDB.getId());
        return studentGetDto;
    }
    public void updateStudent(StudentPostDto studentPostDto){
        Student studentFormDb = studentRepository.findById(studentPostDto.getId()).get();
        studentFormDb.setAge(studentPostDto.getAge());
        studentFormDb.setName(studentPostDto.getName());
        studentRepository.save(studentFormDb);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
