package com.Club.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; import org.springframework.web.bind.annotation.PathVariable; import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; import org.springframework.web.bind.annotation.RequestMapping; import org.springframework.web.bind.annotation.RestController;

import com.Club.Model.Club;
import com.Club.repository.ClubInterface;

@RestController
@RequestMapping("/api/clubs") 

public class Controller {
@Autowired
private ClubInterface clubinterface; 

@GetMapping("/getClub")
public List<Club> getAllClubs() {
	return clubinterface.findAll();
}

@PostMapping("/postClub")
Club newuser (@RequestBody Club newuser) 
 {
	return clubinterface.save(newuser);

 }	

@PutMapping("/updateClub/{id}")
public ResponseEntity<Club> updateUser(@PathVariable Long id, @RequestBody Club updateUser)
{
	Optional<Club> StuData = clubinterface.findById(id);
	if(StuData.isPresent())
	{
		Club user = StuData.get();
		user.setName(updateUser.getName());
		user.setMembers(updateUser.getMembers());
		clubinterface.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}	
}

@DeleteMapping("/deleteStu/{name}")
public ResponseEntity<HttpStatus> deleteuser(@PathVariable String name)
{
	try
	{
		clubinterface.deleteByName(name);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	catch(Exception e) 
	{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

}
