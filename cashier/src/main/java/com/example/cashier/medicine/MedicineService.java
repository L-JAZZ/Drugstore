package com.example.cashier.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MedicineService {
    @Autowired
    private RestTemplate restTemplate;

    public Medicine getMedicine(Long id){
        return restTemplate.getForObject(
                "http://localhost:8088/api/medicine/id/" + id,
                Medicine.class);
    }

}
