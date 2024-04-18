package com.ThreeEntity.Interface;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ThreeEntity.model.Patient; 
public interface PatientInterface extends JpaRepository<Patient, Long> {
}
