package com.employee.employeeconsumer.service;

import com.employee.employeeconsumer.config.EmpConsumerConfig;
import com.employee.employeeconsumer.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeConsumerService {
//    @Autowired
//    ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory = new EmpConsumerConfig().kafkaListenerContainerFactory();

    final static String TOPIC_NAME = "emp_topic";
    final static String PERSIST_EMPLOYEE_FINAL_DB_URL = "http://localhost:9090/final/employee/create";

    RestTemplate restTemplate = new RestTemplate();
    @KafkaListener(topics = TOPIC_NAME,
            groupId ="employee-consumer-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void processMsgFromTopic(ConsumerRecord<String , Employee> consumerRecord){
        System.out.println(consumerRecord.value().getEmail()+"the email id of employee");
        restTemplate.postForEntity(PERSIST_EMPLOYEE_FINAL_DB_URL,consumerRecord.value(),String.class);
    }
    public void processMsgFromTopic(String topicName){

    }

}
