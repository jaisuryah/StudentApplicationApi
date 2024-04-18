package com.ThreeEntity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ThreeEntity.Interface.DoctorInterface;
import com.ThreeEntity.model.Doctor;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorInterface doctorInterface;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorInterface.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorInterface.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorInterface.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor newDoctorData) {
        return doctorInterface.findById(id)
                .map(existingDoctor -> {
                    existingDoctor.setName(newDoctorData.getName());
                    existingDoctor.setSpecialty(newDoctorData.getSpecialty());
                    return doctorInterface.save(existingDoctor);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
    	doctorInterface.deleteById(id);
    }
}
