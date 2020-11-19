package com.example.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @GetMapping("")
    public List<Doctor> doctorsList(){
        return repository.findAll();
    }

    @GetMapping("/id/{doctorId}")
    public Doctor findByID(@PathVariable Long doctorId){
        return repository.findById(doctorId).get();
    }

    @PostMapping("/post")
    public void newDoctor(@RequestBody Doctor doctor){
        repository.save(doctor);
    }

    @DeleteMapping("/deleteByID/{id}")
    public void deleteDoctor(@PathVariable Long id){
        if (id == null){
            throw new NullPointerException("id must not be null");
        }else repository.delete(repository.findById(id).get());
    }
}
