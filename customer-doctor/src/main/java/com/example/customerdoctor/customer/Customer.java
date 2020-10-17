package com.example.customerdoctor.customer;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String surname;
    private double balance;
    private boolean prescription;
}
