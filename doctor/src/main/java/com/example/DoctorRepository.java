package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByName(String name);
}
