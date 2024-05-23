package com.example.apn2_jpa_hebernate;

import com.example.apn2_jpa_hebernate.entities.Patient;
import com.example.apn2_jpa_hebernate.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Apn2JpaHebernateApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Apn2JpaHebernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"omar",new Date(),true,3));
        patientRepository.save(new Patient(null,"kamal",new Date(),false,2));
        patientRepository.save(new Patient(null,"salima",new Date(),true,4));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->
                        System.out.println(p.toString())
                );
        Patient patient = patientRepository.findById(2L).get();
        System.out.println(patient.toString());
        patient.setNom("ikram");
        patientRepository.save(patient);
        patientRepository.deleteById(3L);
        List<Patient> findPatientsByName = patientRepository.findAllByNomContains("l");
        findPatientsByName.forEach(p->
                System.out.println(p.toString())
        );


    }

}
