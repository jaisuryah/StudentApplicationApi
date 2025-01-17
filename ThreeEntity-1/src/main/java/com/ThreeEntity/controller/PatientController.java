package com.ThreeEntity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ThreeEntity.Interface.PatientInterface;
import com.ThreeEntity.model.Patient;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientInterface patientInterface;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientInterface.save(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientInterface.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientInterface.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient newPatientData) {
        return patientInterface.findById(id)
                .map(existingPatient -> {
                    existingPatient.setName(newPatientData.getName());
                    existingPatient.setDateOfBirth(newPatientData.getDateOfBirth());
                    existingPatient.setContactNumber(newPatientData.getContactNumber());
                    existingPatient.setIssue(newPatientData.getIssue());
                    return patientInterface.save(existingPatient);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
    	patientInterface.deleteById(id);
    }
}
