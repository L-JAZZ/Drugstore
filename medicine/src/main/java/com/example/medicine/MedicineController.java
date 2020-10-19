package com.example.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineRepository repository;

    @GetMapping
    public List<Medicine> medicineList(){
        return repository.findAll();
    }

    @GetMapping("/id/{medicineId}")
    public Medicine findById(@PathVariable Long medicineId){
        return repository.findById(medicineId).get();
    }

    @GetMapping("{medName}")
    public Medicine medByName(@PathVariable String medName){
        return repository.findByMedName(medName);
    }

    @PostMapping("/post")
    public void newMedicine(@RequestBody Medicine medicine){
        repository.save(medicine);
    }

    @DeleteMapping("/deleteByID/{id}")
    public void deleteMed(@PathVariable Long id){
        if (id == null){
            throw new NullPointerException("id must not be null");
        }else repository.delete(repository.findById(id).get());
    }
    @PutMapping("/update/{id}")
    public Medicine updateMedicine(@PathVariable Long id,@RequestBody Medicine medicine){
        medicine.setId(id);
        return repository.saveAndFlush(medicine);
    }
}
