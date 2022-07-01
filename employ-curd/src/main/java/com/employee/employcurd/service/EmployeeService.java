package com.employee.employcurd.service;

import com.employee.employcurd.model.Employee;
import com.employee.employcurd.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee getEmployee(Integer empId) {

        Optional<Employee>employee =  employeeRepo.findById(empId);
        log.info("*********fetched-from-db*****\n"+employee.toString());
        return employee.get();
    }

    public void createEmployee(Employee employee) {

        employeeRepo.save(employee);
    }

    public void updateEmployee(Employee employee) {

        employeeRepo.save(employee);
    }

    public void deleteEmployee(Integer empId) {

        employeeRepo.deleteById(empId);
    }
}
