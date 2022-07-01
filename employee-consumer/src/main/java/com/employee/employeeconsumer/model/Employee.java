package com.employee.employeeconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
//    @PrimaryKey
    private int emp_id;
//    @CassandraType(type = CassandraType.Name.TEXT)
    private String first_name;
//    @CassandraType(type = CassandraType.Name.TEXT)
    private String last_name;
//    @CassandraType(type = CassandraType.Name.TEXT)
    private String email;
//    @CassandraType(type = CassandraType.Name.TEXT)
    private String gender;

}