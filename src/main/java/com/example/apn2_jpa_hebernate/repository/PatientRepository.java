package com.example.apn2_jpa_hebernate.repository;

import com.example.apn2_jpa_hebernate.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findAllByNomContains(String name);
}
