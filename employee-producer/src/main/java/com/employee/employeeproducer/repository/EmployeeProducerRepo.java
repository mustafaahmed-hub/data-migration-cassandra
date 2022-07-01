package com.employee.employeeproducer.repository;

import com.employee.employeeproducer.model.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProducerRepo extends CassandraRepository<Employee, Integer> {
}
