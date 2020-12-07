package com.example.customer;

import com.example.customer.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public List<Customer> medicineList(){
        return repository.findAll();
    }

    @GetMapping("/id/{customerId}")
    public Customer findByID(@PathVariable Long customerId){
        return repository.findById(customerId).get();
    }

    @PostMapping("/post")
    public void newCustomer(@RequestBody Customer customer){
        repository.save(customer);
    }

    @DeleteMapping("/deleteByID/{id}")
    public void deleteCustomer(@PathVariable Long id){
        if (id == null){
            throw new NullPointerException("id must not be null");
        }else repository.delete(repository.findById(id).get());
    }

    private static final String TOPIC = "customer_json";

    @Autowired
    KafkaTemplate<String, Customer> kafkaTemplate;
    @GetMapping("/send/{id}")
    public String sendCustomer(@PathVariable("id") long id){
        kafkaTemplate.send(TOPIC,findByID(id));
        return "done";
    }
}
