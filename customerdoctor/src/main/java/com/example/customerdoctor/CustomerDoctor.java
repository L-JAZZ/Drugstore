package com.example.customerdoctor;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CustomerDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    private Long doctorID;
    private String docName;
    private String docSurname;
    private String customerName;
    private String customerSurname;
    private boolean prescription;
}
