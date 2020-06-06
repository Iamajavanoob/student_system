package com.li.back.repositories;
import static org.junit.Assert.*;

import com.li.back.entity.Student;
import com.li.back.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testAddStudent() {
        Student studentForAdding = new Student();
        studentForAdding.setName("userforadding");
        Student returnedStudentAfterAdding = studentRepository.save(studentForAdding);
        assertEquals(studentForAdding.getName(), returnedStudentAfterAdding.getName());

    }

    @Test
    public void testFindAllStudent() {
        Student student1 = new Student();
        student1.setName("student");
        studentRepository.save(student1);
        Assert.assertEquals("student",studentRepository.findAll().get(0).getName());

    }


    @Test
    public void testFindById(){
        Student student1 = new Student();
        student1.setName("test");
        student1.setId(1l);
        studentRepository.save(student1);
        Assert.assertEquals("test",studentRepository.findById(1l).get().getName());



    }
}
