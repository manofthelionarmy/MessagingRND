package com.example.server.application.customer.event_handling;

import com.example.server.application.customer.service.CustomerService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventProducerConfiguration {

    @Bean
    public Exchange eventExchange(){
        return new TopicExchange("eventExchange");
    }

    @Bean
    public CustomerService customerService(RabbitTemplate rabbitTemplate, Exchange exchange){
        return new CustomerService(rabbitTemplate, exchange);
    }
}
