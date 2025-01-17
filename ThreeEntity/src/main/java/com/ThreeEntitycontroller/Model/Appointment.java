package com.ThreeEntitycontroller.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appoitments")
public class Appointment { @Id
@GeneratedValue
private Long appointmentId;
private String date; private String time;

@ManyToOne @JoinColumn(name = "patient_id") 
private Patient patient;

@ManyToOne @JoinColumn(name = "doctor_id") 
private Doctor doctor;

public Long getAppointmentId() { return appointmentId;
}

public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId;
}

public String getDate() {
return date;
 
}

public void setDate(String date) { this.date = date;
}

public String getTime() {
return time;
}

public void setTime(String time) { this.time = time;
}

public Patient getPatient() { return patient;
}

public void setPatient(Patient patient) { this.patient = patient;
}

public Doctor getDoctor() {
return doctor;
}

public void setDoctor(Doctor doctor) { this.doctor = doctor;
}

}
