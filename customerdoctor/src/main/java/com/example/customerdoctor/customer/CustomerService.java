package com.example.customerdoctor.customer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            defaultFallback  = "getFallbackCustomer",
            threadPoolKey = "getCustomerPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "20"),
                    @HystrixProperty(name = "maxQueueSize",value = "10"),
            }
    )
    public Customer getCustomer(Long id){
        return restTemplate.getForObject(
                        "http://localhost:8086/api/customer/id/" + id,
                Customer.class);
    }

    public Customer getFallbackCustomer(){
        Customer customer = new Customer();
        customer.setPrescription(false);
        customer.setBalance(0);
        customer.setName("Missing customer");
        customer.setSurname("No customer");
        return customer;
    }
}
