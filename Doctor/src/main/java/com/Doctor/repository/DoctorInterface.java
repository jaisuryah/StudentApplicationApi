package com.Doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Doctor.model.Doctor;

public interface DoctorInterface extends JpaRepository<Doctor, Long>{

}
