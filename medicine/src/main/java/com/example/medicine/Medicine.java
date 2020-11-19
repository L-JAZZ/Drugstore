package com.example.medicine;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String medName;
    private int quantity;
    private double price;
    private boolean prescription;
}
