package com.li.back.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.li.back.dto.StudentGetDto;
import com.li.back.dto.StudentPostDto;
import com.li.back.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StudentAddController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void testAddStudentWithValidData() throws Exception {
        StudentPostDto studentPostDto = new StudentPostDto();
        studentPostDto.setName("mock_name");
        studentPostDto.setAge(22);

        StudentGetDto studentGetDto = new StudentGetDto();
        studentGetDto.setName("mock_Get");
        studentGetDto.setAge(0);
        BDDMockito.given(studentService.addStudent(studentPostDto)).willReturn(studentGetDto);

        mockMvc.perform(post("/add")
                .content(objectMapper.writeValueAsString(studentPostDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}




