package com.activeedge.dtos;

import com.activeedge.models.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateEmployeeDtoMapper {

    @Autowired
    static ModelMapper modelMapper;

    public static Employee updateEmployee(UpdateEmployeeDto updateEmployeeDto){
        Employee employee = modelMapper.map(updateEmployeeDto, Employee.class);
        return employee;
    }
}
