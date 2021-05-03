package com.activeedge.services;

import com.activeedge.Exceptions.AppException;
import com.activeedge.dtos.CreateEmployeeDto;
import com.activeedge.dtos.UpdateEmployeeDto;
import com.activeedge.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(CreateEmployeeDto createEmployeeDto);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id) throws AppException;
    Employee  updateEmployee(UpdateEmployeeDto updateEmployeeDto, Integer id) throws AppException;
    void deleteEmployee(Integer id) throws AppException;
}
