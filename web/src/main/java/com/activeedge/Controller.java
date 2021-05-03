package com.activeedge;

import com.activeedge.Exceptions.AppException;
import com.activeedge.dtos.CreateEmployeeDto;
import com.activeedge.dtos.UpdateEmployeeDto;
import com.activeedge.models.Employee;
import com.activeedge.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/create-employee")
    public ResponseEntity<?> createNewEmployee(CreateEmployeeDto createEmployeeDto) throws AppException {
        try{
            Employee employee = employeeService.createEmployee(createEmployeeDto);
        }
        catch(Exception e){
            throw new AppException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-all-employees")
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> all = employeeService.getAllEmployees();
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/get-employee/id")
    public ResponseEntity<?> getOneEmployee(@PathVariable int id) throws AppException {
        try{
            Employee employee = employeeService.getEmployeeById(id);
        }
        catch(Exception e){
            throw new AppException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @DeleteMapping("remove-employee/id")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) throws AppException {
        try{
            employeeService.deleteEmployee(id);
        }
        catch(Exception e){
            throw new AppException(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PatchMapping("/update-employee")
    public ResponseEntity<?> updateEmployee(UpdateEmployeeDto updateEmployeeDto, @PathVariable Integer id) throws AppException {
        employeeService.updateEmployee(updateEmployeeDto, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
