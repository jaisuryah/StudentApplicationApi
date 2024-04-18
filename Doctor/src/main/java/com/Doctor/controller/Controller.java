package com.Doctor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Doctor.model.Doctor;
import com.Doctor.repository.DoctorInterface;

@RestController
@RequestMapping("/Hospital")
public class Controller {
	
	@Autowired
	private DoctorInterface doctorinterface;
	
	@GetMapping("/getDoc")
	public List<Doctor> getAllDoctors()
	{
		return doctorinterface.findAll();
	}
	
	@PostMapping("/addDoctor")
	public Doctor newDoc(@RequestBody Doctor newDoc)
	{
		return doctorinterface.save(newDoc);
	}
	
	@PutMapping("/updateDoc/{id}")
	public ResponseEntity<Doctor> updateDoc(@PathVariable Long id,@RequestBody Doctor updateDoc)
	{
		Optional<Doctor> docData = doctorinterface.findById(id);
		if(docData.isPresent())
		{
			Doctor user = docData.get();
			user.setName(updateDoc.getName());
			user.setSpeciality(updateDoc.getSpeciality());
			user.setPatient(updateDoc.getPatient());
			doctorinterface.save(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("deleteDoc/{id}")
	public ResponseEntity<HttpStatus> deleteDoc(@PathVariable Long id)
	{
		try
		{
			doctorinterface.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
