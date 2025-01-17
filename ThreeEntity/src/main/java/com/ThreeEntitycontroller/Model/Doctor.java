package com.ThreeEntitycontroller.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctors")
public class Doctor
{
	@Id
	@GeneratedValue
	private Long doctorId;
	private String name; 
	private String specialty;
// Getters and setters
public Long getDoctorId() {
return doctorId;
 
}
public void setDoctorId(Long doctorId) { this.doctorId = doctorId;
}
public String getName() {
return name;
}
public void setName(String name) { this.name = name;
}
public String getSpecialty() { return specialty;
}
public void setSpecialty(String specialty) { this.specialty = specialty;
}

}

