package com.example.cashier.medicine;

import lombok.Data;

import javax.persistence.*;

@Data
public class Medicine {
    private Long id;
    private String medName;
    private int quantity;
    private double price;
    private boolean prescription;
}
