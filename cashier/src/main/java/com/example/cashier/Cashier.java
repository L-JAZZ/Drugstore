package com.example.cashier;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cashier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long MedicineId;
    private String custName;
    private String custSurname;
    private String medName;
    private int quantity;
    private String result;
    private boolean prescription;

}
