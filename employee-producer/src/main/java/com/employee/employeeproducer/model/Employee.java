package com.employee.employeeproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "employee_table")
public class Employee {
    @PrimaryKey
    private int emp_id;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String first_name;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String last_name;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String email;
    @CassandraType(type = CassandraType.Name.TEXT)
    private String gender;

}
