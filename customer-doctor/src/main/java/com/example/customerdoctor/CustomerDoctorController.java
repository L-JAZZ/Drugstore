package com.example.customerdoctor;

import com.example.customerdoctor.customer.Customer;
import com.example.customerdoctor.customer.CustomerService;
import com.example.customerdoctor.doctor.Doctor;
import com.example.customerdoctor.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custdoc")
public class CustomerDoctorController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private CustomerDoctorRepository repository;

    @GetMapping("")
    public List<CustomerDoctor> centerReps(){
        return repository.findAll();
    }

    @PostMapping("/{doctorId}/{customerId}")
    public void addCustToDoc(@PathVariable Long doctorId, @PathVariable Long customerId){

        Doctor doctor = doctorService.getDoctor(doctorId);
        Customer customer = customerService.getCustomer(customerId);
        CustomerDoctor hospital = new CustomerDoctor();

        //set all values to Cust-Doc DB
        hospital.setDoctorID(doctor.getId());
        hospital.setDocName(doctor.getName());
        hospital.setDocSurname(doctor.getSurname());
        hospital.setCustomerID(customer.getId());
        hospital.setCustomerName(customer.getName());
        hospital.setCustomerSurname(customer.getSurname());
        hospital.setPrescription(customer.isPrescription());

        repository.save(hospital);
    }

    //spaghetti code will be fixed
    @PutMapping("/addprecr/{doctorId}/{customerID}")
    public void addPrecr(@PathVariable Long customerID,@PathVariable Long doctorId){
        Customer customer = customerService.getCustomer(customerID);
        CustomerDoctor hospital = new CustomerDoctor();
        Doctor doctor = doctorService.getDoctor(doctorId);

        customer.setPrescription(true);
        //set all values to Cust-Doc DB
        hospital.setDoctorID(doctor.getId());
        hospital.setDocName(doctor.getName());
        hospital.setDocSurname(doctor.getSurname());
        hospital.setCustomerID(customer.getId());
        hospital.setCustomerName(customer.getName());
        hospital.setCustomerSurname(customer.getSurname());
        hospital.setPrescription(customer.isPrescription());
        repository.save(hospital);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCustdoc(@PathVariable Long id){
        repository.deleteById(id);
    }
}
