package com.techsharezone.springboot.dlq.example.config;

/*
 * @created 06/02/2021 -00:12
 * @project spring-boot-dlq-example
 * @author  saurabhshcs
 */

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    DirectExchange deadLetterExchange() {
        return new DirectExchange("deadLetterExchange");
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("techsharezoneExchange");
    }

    @Bean
    Queue dlq() {
        return QueueBuilder.durable("deadletter.queue").build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable("techsharezone.queue").withArgument("x-dead-letter-exchange", "deadLetterExchange")
                .withArgument("x-dead-letter-routing-key", "deadLetter").build();
    }

    @Bean
    Binding DLQBinding() {
        return BindingBuilder.bind(dlq()).to(deadLetterExchange()).with("deadletter");
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("techsharezone");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}