package com.iitu.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "customer_json", groupId = "group_id")
    public void consume(Customer customer) throws IOException {
        System.out.println(customer.toString());
    }
}
