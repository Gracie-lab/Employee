package com.activeedge.repositories;

import com.activeedge.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
