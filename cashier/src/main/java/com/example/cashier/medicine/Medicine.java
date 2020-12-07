package com.example.cashier.medicine;

import lombok.Data;

@Data
public class Medicine {
    private Long id;
    private String medName;
    private int quantity;
    private double price;
    private boolean prescription;
}
