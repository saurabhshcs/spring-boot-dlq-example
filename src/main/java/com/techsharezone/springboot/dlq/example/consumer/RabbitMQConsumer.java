package com.techsharezone.springboot.dlq.example.consumer;

/*
 * @created 06/02/2021 -00:53
 * @project spring-boot-dlq-example
 * @author  saurabhshcs
 */

import com.techsharezone.springboot.dlq.example.exception.InvalidSalaryException;
import com.techsharezone.springboot.dlq.example.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "techsharezone.queue")
    public void receivedMessage(Employee employee) {
        log.info("Recieved message from the queue {}", employee);

        if (employee.getSalary() < 0) {
            throw new InvalidSalaryException();
        }
    }
}
