package com.example.server.application.customer.service;

import com.example.server.application.customer.model.Customer;
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerService {

    private AtomicLong counter = new AtomicLong();
    private final RabbitTemplate rabbitTemplate;

    private final Exchange exchange;

    public CustomerService(RabbitTemplate rabbitTemplate, Exchange exchange){
        this.exchange = exchange;
        this.rabbitTemplate = rabbitTemplate;
    }

    public ResponseEntity<?> add(Customer customer){

        if(customer == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        customer.setId(counter.getAndIncrement());

        String routingKey = "customer.created";
        String message = "customer created";

        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


}
