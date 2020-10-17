package com.example.customerdoctor.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorService {

    @Autowired
    private RestTemplate restTemplate;

    public Doctor getDoctor(Long id){
        return restTemplate.getForObject(
                "http://localhost:8087/api/doctor/id/" + id,
                Doctor.class);
    }
}
