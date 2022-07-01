package com.employee.employeeproducer.controller;


import com.employee.employeeproducer.dto.PubMsgDTo;
import com.employee.employeeproducer.model.Employee;
import com.employee.employeeproducer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/producer")
public class EmployeeProducerController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/pubmsg")
    public ResponseEntity publishMessages(@RequestBody PubMsgDTo pubMsgDTo){
        employeeService.publishMessages(pubMsgDTo.getTopicName());
        return ResponseEntity.status(HttpStatus.OK).body("Publishing Messages to topic-> "+pubMsgDTo.getTopicName());
    }
    @PostMapping("/createEmployee")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body("Employee Created");
    }
    @GetMapping("/load-data")
    public ResponseEntity loadDataInDB(){
        employeeService.init();
        return ResponseEntity.status(HttpStatus.OK).body("Loading data in DB");
    }
}
