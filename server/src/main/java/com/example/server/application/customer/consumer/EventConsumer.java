package com.example.server.application.customer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class EventConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RabbitListener(queues = "orderServiceQueue")
    public void receive(String message) throws Exception{
        System.out.println(message);

        messagingTemplate.convertAndSend("/topic/queuedMessage", message);
    }
}
