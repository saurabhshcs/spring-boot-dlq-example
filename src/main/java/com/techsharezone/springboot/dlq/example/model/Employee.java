package com.techsharezone.springboot.dlq.example.model;

/*
 * @created 06/02/2021 -00:07
 * @project spring-boot-dlq-example
 * @author  saurabhshcs
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private String empName;

    private String empId;
    private int salary;
}
