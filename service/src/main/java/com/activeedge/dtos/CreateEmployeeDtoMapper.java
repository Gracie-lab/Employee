package com.activeedge.dtos;

import com.activeedge.models.Employee;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CreateEmployeeDtoMapper {

    static ModelMapper modelMapper = new ModelMapper();

    public static Employee createEmployeeFrom(CreateEmployeeDto createEmployeeDto){
        Employee employee = modelMapper.map(createEmployeeDto, Employee.class);
        return employee;

    }
}
