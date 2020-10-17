package com.example.customerdoctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDoctorRepository extends JpaRepository<CustomerDoctor,Long> {

}
