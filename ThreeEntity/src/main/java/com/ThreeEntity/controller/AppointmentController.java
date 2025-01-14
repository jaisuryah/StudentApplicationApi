package com.ThreeEntity.controller;

import com.ThreeEntity.Interface.AppointmentRepository;
import com.ThreeEntitycontroller.Model.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping
    public Appointment scheduleAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/reschedule")
    public Appointment rescheduleAppointment(@PathVariable Long id, @RequestParam String newDate, @RequestParam String newTime) {
        return appointmentRepository.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setDate(newDate);
                    existingAppointment.setTime(newTime);
                    return appointmentRepository.save(existingAppointment);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
    }
}
