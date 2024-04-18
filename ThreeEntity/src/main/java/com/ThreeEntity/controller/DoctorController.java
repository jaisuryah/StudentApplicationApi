package com.ThreeEntity.controller;

import com.ThreeEntity.Interface.DoctorRepository;
import com.ThreeEntitycontroller.Model.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor newDoctorData) {
        return doctorRepository.findById(id)
                .map(existingDoctor -> {
                    existingDoctor.setName(newDoctorData.getName());
                    existingDoctor.setSpecialty(newDoctorData.getSpecialty());
                    return doctorRepository.save(existingDoctor);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }
}
