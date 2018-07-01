package com.example.server.application.customer.event_handling;

import com.example.server.application.customer.consumer.EventConsumer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConsumerConfiguration {

    @Bean
    public Exchange eventExchange(){
        return new TopicExchange("eventExchange");
    }
    @Bean
    public Queue queue(){
        return new Queue("orderServiceQueue");
    }
    @Bean
    public Binding binding(Queue queue, Exchange exchange){

       return BindingBuilder.bind(queue).to(exchange).with("customer.*").noargs();
    }
    @Bean
    public EventConsumer eventReceiver(){
        return new EventConsumer();
    }

}
