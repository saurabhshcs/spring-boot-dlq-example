package com.techsharezone.springboot.dlq.example.controller;

/*
 * @created 06/02/2021 -00:33
 * @project spring-boot-dlq-example
 * @author  saurabhshcs
 */

import com.techsharezone.springboot.dlq.example.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private AmqpTemplate template;

    @GetMapping(value = "/produce")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId, @RequestParam("salary") Integer salary) {
        Employee employee = Employee.builder()
                .empName(empName)
                .empId(empId)
                .salary(salary)
                .build();
        template.convertAndSend("techsharezoneExchange", "techsharezone", employee);
        log.info("Message sent to rabbitmq successfully...");
        return "Message sent to RabbitMQ Successfully";
    }
}
