package com.example.server.application.customer.controller;

import com.example.server.application.customer.model.Customer;
import com.example.server.application.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private List<Customer> list = new ArrayList<>();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return list;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCustomer")
    public void addCustomer(@RequestBody Customer customer){
        try{
            list.add((Customer)(this.customerService.add(customer).getBody()));
            System.out.println("Customer added");
        }
        catch (Error error){
            System.out.println(error.getCause());
        }
    }

    @SendTo("/topic/queuedMessage")
    public String notify(String message){
        return message;
    }

}
