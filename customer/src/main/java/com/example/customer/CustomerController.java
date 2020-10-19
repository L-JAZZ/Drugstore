package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("{name}")
    public Customer customerByName(@PathVariable String name){
        return repository.findByName(name);
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

    @PutMapping("/update/{id}")
    public Customer updateDoctor(@PathVariable Long id,@RequestBody Customer customer){
        customer.setId(id);
        return repository.saveAndFlush(customer);
    }
}
