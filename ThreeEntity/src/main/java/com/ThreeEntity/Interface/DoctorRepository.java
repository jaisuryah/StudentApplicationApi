package com.ThreeEntity.Interface;


import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;

import com.ThreeEntitycontroller.Model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}