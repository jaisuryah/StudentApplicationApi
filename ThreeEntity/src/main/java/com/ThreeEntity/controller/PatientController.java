package com.ThreeEntity.controller;

import com.ThreeEntity.Interface.PatientRepository;
import com.ThreeEntitycontroller.Model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient newPatientData) {
        return patientRepository.findById(id)
                .map(existingPatient -> {
                    existingPatient.setName(newPatientData.getName());
                    existingPatient.setDateOfBirth(newPatientData.getDateOfBirth());
                    existingPatient.setContactNumber(newPatientData.getContactNumber());
                    existingPatient.setIssue(newPatientData.getIssue());
                    return patientRepository.save(existingPatient);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
