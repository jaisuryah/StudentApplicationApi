package com.ThreeEntity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ThreeEntity.Interface.AppointmentInterface;
import com.ThreeEntity.model.Appointment;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppoitmentController {

    @Autowired
    private AppointmentInterface appointmentinterface;

    @PostMapping
    public Appointment scheduleAppointment(@RequestBody Appointment appointment) {
        return appointmentinterface.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentinterface.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentinterface.findById(id).orElse(null);
    }

    @PutMapping("/{id}/reschedule")
    public Appointment rescheduleAppointment(@PathVariable Long id, @RequestParam String newDate, @RequestParam String newTime) {
        return appointmentinterface.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setDate(newDate);
                    existingAppointment.setTime(newTime);
                    return appointmentinterface.save(existingAppointment);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable Long id) {
    	appointmentinterface.deleteById(id);
    }
}
