package com.example.customerdoctor.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;

    public Customer getCustomer(Long id){
        return restTemplate.getForObject(
                        "http://localhost:8086/api/customer/id/" + id,
                Customer.class);
    }

}
