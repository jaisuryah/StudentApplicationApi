package com.ThreeEntity.Interface;

import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;

import com.ThreeEntitycontroller.Model.Appointment;



public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}