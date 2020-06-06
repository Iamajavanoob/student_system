package com.li.back.service;

import com.li.back.dto.StudentGetDto;
import com.li.back.repository.StudentRepository;

import com.li.back.dto.StudentPostDto;
import com.li.back.entity.Student;
import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceWithMockTest {

    @Mock
    private StudentRepository studentRepository;

    @Resource
    @InjectMocks
    private StudentService studentService;

    @Test
    public void testAddStudentWithMockRepository(){
        Student student = new Student();
        student.setName("mock_name");
        when(studentRepository.save(any())).thenReturn(student);


        StudentPostDto studentPostDto = new StudentPostDto();
        studentPostDto.setName("abc");
        studentPostDto.setAge(22);
        StudentGetDto returnStudent = studentService.addStudent(studentPostDto);
        Assert.assertEquals(returnStudent.getName(),student.getName());
    }
    @Test
    public void testDeleteStudentWithMockRepository(){
        Long id = new Random().nextLong();
        doNothing().when(studentRepository).deleteById(id);
        studentService.deleteStudent(id);
        verify(studentRepository,times(1)).deleteById(id);

    }

    @Test
    public void testFindAllWithMockRepository(){
        Student student1 = new Student();
        student1.setName("mock_student");
        List<Student> students = Collections.singletonList(student1);
        when(studentRepository.findAll()).thenReturn(students);

        Student student2 = new Student();
        student2.setName("abc");
        student2.setAge(11);
        List<Student> returnStudents = (List<Student>) studentService.findAll();
//      Assert.assertEquals(students.get(0).getName(),returnStudents.get(0).getName());
        students.iterator().forEachRemaining(e->
        {String test_mock = e.getName();
        returnStudents.iterator().forEachRemaining(m->{ Assert.assertEquals(test_mock,m.getName());});
        });
    }






}
