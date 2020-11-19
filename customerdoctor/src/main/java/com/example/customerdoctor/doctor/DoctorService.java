package com.example.customerdoctor.doctor;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackDoctor")
    public Doctor getDoctor(Long id){
        return restTemplate.getForObject(
                "http://localhost:8087/api/doctor/id/" + id,
                Doctor.class);
    }
 
    public Doctor getFallbackDoctor(Long id){
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setName("nobody");
        doctor.setSurname("of nobody");
        return doctor;
    }
}
