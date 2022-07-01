package com.employee.employcurd.repository;

import com.employee.employcurd.model.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CassandraRepository<Employee , Integer> {

}
