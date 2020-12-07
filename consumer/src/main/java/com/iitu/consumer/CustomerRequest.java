package com.iitu.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private Customer customer;

    public Customer getAuthor() {
        return customer;
    }

    public void setAuthor(Customer customer) {
        this.customer = customer;
    }
}
