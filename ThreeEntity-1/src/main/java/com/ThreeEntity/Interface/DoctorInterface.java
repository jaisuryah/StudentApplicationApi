package com.ThreeEntity.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ThreeEntity.model.Doctor;

public interface DoctorInterface extends JpaRepository<Doctor, Long> {
}
