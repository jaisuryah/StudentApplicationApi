package com.sample_crud1.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.sample_crud1.model.userModel;
import com.sample_crud1.repository.userInterface;

@RestController
@RequestMapping("/crud")
public class userController {

	@Autowired
	private userInterface userInterface;
	@GetMapping("/getuser")
	List<userModel> getAllUsers()
	{
		return userInterface.findAll();
	}
	
	@GetMapping("/users/{page}/{size}")
	public Page<userModel> getAllUsers(@PathVariable int page,@PathVariable int size)
	{
		Pageable PageData = PageRequest.of(page, size);
				return userInterface.findAll(PageData);
		
	}
	
	@GetMapping("/INQuery/{Sid}/{Eid}")
	public List<userModel> getInByQuery(@PathVariable Long Sid,@PathVariable Long Eid)
	{
		return userInterface.FindByInQuery(Sid,Eid);
	}
	
	
	@PostMapping("/adduser")
	userModel newUser(@RequestBody userModel newUser)
	{
		return userInterface.save(newUser);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<userModel> updateUser(@PathVariable Long id, @RequestBody userModel updateUser)
	{
		Optional<userModel> userData = userInterface.findById(id);
		if(userData.isPresent())
		{
			userModel user = userData.get();
			user.setName(updateUser.getName());
			user.setIncome(updateUser.getIncome());
			userInterface.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<HttpStatus> deleteuser(@PathVariable Long id)
	{
		try
		{
			userInterface.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}


