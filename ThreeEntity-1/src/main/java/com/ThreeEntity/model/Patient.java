package com.ThreeEntity.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient { 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long patientId;
 
private String name; 
private String dateOfBirth;
private String contactNumber; 
private String issue;
@ManyToOne
@JoinColumn(name = "doctor_id")
private Doctor doctor;

public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}
public Long getPatientId() {
	return patientId;
}
public void setPatientId(Long patientId) {
	this.patientId = patientId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getIssue() {
	return issue;
}
public void setIssue(String issue) {
	this.issue = issue;
}


}
