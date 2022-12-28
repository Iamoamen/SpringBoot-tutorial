package com.springboot.SpringBoottutorial.controller;

import com.springboot.SpringBoottutorial.entity.Department;
import com.springboot.SpringBoottutorial.error.DepartmentNotFoundException;
import com.springboot.SpringBoottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc ;
    @MockBean
    private DepartmentService departmentService;

    private Department department ;

    @BeforeEach
    void setUp(){
        department = Department.builder()
                .departmentAddress("Cairo")
                .departmentCode("EE-8")
                .departmentName("SSS")
                .departmentId(1L)
                .build() ;

    }
    @Test
    void saveDepartment() throws Exception {
       Department inputdepartment = Department.builder()
                .departmentAddress("Cairo")
                .departmentCode("EE-8")
                .departmentName("SSS")
                .build() ;

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department) ;
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"SSS\",\n" +
                        "\t\"departmentAddress\":\"Cairo\",\n" +
                        "\t\"departmentCode\":\"EE-8\"\n" +
                        "\t\n" +
                        "}"))
                .andExpect(status().isOk()) ;
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department) ;
        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").
                        value(department.getDepartmentName())) ;
    }
}