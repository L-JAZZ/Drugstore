package com.example.cashier;

import com.example.cashier.customer.Customer;
import com.example.cashier.customer.CustomerService;
import com.example.cashier.medicine.Medicine;
import com.example.cashier.medicine.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cashier")
public class CashierController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private CashierRepository repository;

    @GetMapping("/get")
    public List<Cashier> getCashier(){
        return repository.findAll();
    }

    @PostMapping("/sell/{customerId}/{medicineId}")
    public void sellMedicine(@PathVariable Long customerId,@PathVariable Long medicineId){
        Customer customer = customerService.getCustomer(customerId);
        Medicine medicine = medicineService.getMedicine(medicineId);
        Cashier cashier = new Cashier();

        cashier.setCustomerId(customer.getId());
        cashier.setCustName(customer.getName());
        cashier.setCustSurname(customer.getSurname());
        cashier.setMedName(medicine.getMedName());
        cashier.setMedicineId(medicine.getId());
        cashier.setPrescription(customer.isPrescription());
        cashier.setResult("default");

        if(customer.getBalance()<medicine.getPrice()){
            cashier.setResult("not enough money!");
        }
        else if(!(medicine.isPrescription() && customer.isPrescription())){
            cashier.setResult("no prescription!");
        }else if(medicine.getQuantity()==0){
            cashier.setResult("Out of stock");
        }
        else {
            cashier.setResult("Successful purchase!");
            cashier.setQuantity(medicine.getQuantity()-1);
        }
        repository.save(cashier);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCashier(@PathVariable Long id){
        repository.deleteById(id);
    }
}
