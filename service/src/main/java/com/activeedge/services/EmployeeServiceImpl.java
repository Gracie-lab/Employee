package com.activeedge.services;

import com.activeedge.Exceptions.AppException;
import com.activeedge.dtos.CreateEmployeeDto;
import com.activeedge.dtos.CreateEmployeeDtoMapper;
import com.activeedge.dtos.UpdateEmployeeDto;
import com.activeedge.dtos.UpdateEmployeeDtoMapper;
import com.activeedge.models.Employee;
import com.activeedge.repositories.EmployeeRepository;
import com.activeedge.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(CreateEmployeeDto createEmployeeDto) {
        Employee newEmployee = CreateEmployeeDtoMapper.createEmployeeFrom(createEmployeeDto);
        employeeRepository.save(newEmployee);
        return newEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {
       List<Employee> allEmployees = employeeRepository.findAll();
       return allEmployees;
    }

    @Override
    public Employee getEmployeeById(Integer id) throws AppException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new AppException("Employee does not exist");
        }
        else {
            Employee employee = optionalEmployee.get();
            return employee;
        }
    }

    @Override
    public Employee updateEmployee(UpdateEmployeeDto updateEmployeeDto, Integer id) throws AppException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new AppException("Employee does not exist");
        }
        else{
            Employee updatedEmployee = UpdateEmployeeDtoMapper.updateEmployee(updateEmployeeDto);
            return updatedEmployee;

        }

    }

    @Override
    public void deleteEmployee(Integer id) throws AppException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new AppException("Employee does not exist");
        }
        else{
            employeeRepository.deleteById(id);
        }

    }
}
