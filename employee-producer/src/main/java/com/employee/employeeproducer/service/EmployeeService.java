package com.employee.employeeproducer.service;

import com.employee.employeeproducer.config.EmpProducerConfig;
import com.employee.employeeproducer.model.Employee;
import com.employee.employeeproducer.repository.EmployeeProducerRepo;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeProducerRepo employeeProducerRepo;
    @Autowired
    KafkaTemplate<String, Employee> kafkaTemplate;

    //    KafkaTemplate<String , Employee> kafkaTemplate = new EmpProducerConfig().kafkaTemplate();
    public void publishMessages(String topicName) {
        List<Employee> employeeList = employeeProducerRepo.findAll();
        employeeList.stream().forEach(e -> {
            kafkaTemplate.send(new ProducerRecord<>(topicName, String.valueOf(e.getEmp_id()), e));
        });
    }

    public void createEmployee(Employee employee) {
        employeeProducerRepo.save(employee);
    }


    //used to load data to DB
    public void init() {

        File f = new File("C:\\Users\\musahmed1\\Desktop\\training\\data-migration\\employee-producer\\src\\main\\resources\\MOCK_DATA.csv");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        int flag = 0;
        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String value[] = line.split(",");

            if (flag == 0) {
                flag++;
                continue;
            }
            Employee employee = new Employee(Integer.parseInt(value[0]), value[1], value[2], value[3], value[4]);
            employeeProducerRepo.save(employee);

        }
    }
}
