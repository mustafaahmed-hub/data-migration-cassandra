package com.employee.employcurd.controller;
import com.employee.employcurd.model.Employee;
import com.employee.employcurd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/final/employee")
public class EmplyeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private Map<Integer,Employee> employeeMap;

    @GetMapping("/{empId}")
    public ResponseEntity getEmployee(@PathVariable Integer empId){
        Employee employee =  (employeeMap.get(empId)!=null)?employeeMap.get(empId): employeeService.getEmployee(empId);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }
    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        employeeMap.put(employee.getEmp_id(),employee);
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }
    @PutMapping("/update")
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        employeeMap.put(employee.getEmp_id(),employee);
        employeeService.updateEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity deleteEmployee(@PathVariable Integer empId){
        employeeMap.remove(empId);
        employeeService.deleteEmployee(empId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Deleted");

    }


}
