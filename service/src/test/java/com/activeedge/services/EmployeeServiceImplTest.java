package com.activeedge.services;

import com.activeedge.dtos.CreateEmployeeDto;
import com.activeedge.dtos.CreateEmployeeDtoMapper;
import com.activeedge.models.Employee;
import com.activeedge.repositories.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_I_Can_Create_Employee(){
        CreateEmployeeDto employeeDto = new CreateEmployeeDto();
        employeeDto.setFirst_name("Name");
        employeeDto.setLast_name("Surname");

        Employee employee = CreateEmployeeDtoMapper.createEmployeeFrom(employeeDto);
        when(employeeRepository.save(employee)).thenReturn(employee);

        employeeService.createEmployee(employeeDto);

       verify(employeeRepository, times(1)).save(employee);

    }


}