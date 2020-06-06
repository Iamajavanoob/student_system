package com.li.back.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.li.back.entity.Student;
import com.li.back.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StudentAddController.class)
public class StudentDeleteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testDeleteStudentWithValidData() throws Exception{
        Long id = new Random().nextLong();
        Student student = new Student();
        student.setAge(0);
        student.setName("mock");
        doNothing().when(studentService).deleteStudent(student.getId());

        mockMvc.perform(delete("/deleteById/{id}",student.getId())
                .content(objectMapper.writeValueAsString(student.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());



    }
}
