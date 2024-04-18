package com.ThreeEntity.Interface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ThreeEntity.model.Appointment;

public interface AppointmentInterface extends JpaRepository<Appointment,Long>{

}
