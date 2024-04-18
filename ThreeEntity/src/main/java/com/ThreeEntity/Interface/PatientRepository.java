package com.ThreeEntity.Interface;

import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;

import com.ThreeEntitycontroller.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
