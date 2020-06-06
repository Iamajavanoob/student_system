package com.li.back.controller;

import com.li.back.entity.Student;
import com.li.back.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StudentAddController.class)
public class StudentFindControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;

    @Test
    public void testFindStudentWithValidData() throws Exception {
        Student student = new Student();
        student.setName("mock");
        student.setAge(0);
        List<Student> students = Arrays.asList(student);
        BDDMockito.given(studentService.findAll()).willReturn(students);

        mockMvc.perform(get("/find"))
                .andExpect(status().isOk());



    }
}
