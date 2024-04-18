package com.Student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.Student.Model.StuModel;
import com.Student.Repository.StuInterface;



@RestController
@RequestMapping("/School")
public class StuController {

	@Autowired
	private StuInterface stuInterface;
	
	
	@GetMapping("/getStu")
	List<StuModel> getAllUsers()
	{
		return stuInterface.findAll();
	}
	
	@GetMapping("/getStu/{id}")
	public Optional<StuModel> getAllUsersById(@PathVariable Long id)
	{
		return stuInterface.findById(id);
	}

	@GetMapping("/AND/{name}/{marks}")
	public List<StuModel> getByNameAndMarks(@PathVariable String name, @PathVariable Double marks)
	{
			return stuInterface.findByNameAndMarks(name,marks);
	}
	
	@GetMapping("/OR/{name}/{marks}")
	public List<StuModel> getByNameOrMarks(@PathVariable String name, @PathVariable Double marks)
	{
		return stuInterface.findByNameOrMarks(name,marks);
	}
	
	@GetMapping("/users/{page}/{size}")
	public Page<StuModel> getAllUsers(@PathVariable int page,@PathVariable int size)
	{
		Pageable PageData = PageRequest.of(page, size,Sort.Direction.ASC,"regno");
				return stuInterface.findAll(PageData);
		
	}
	
	@GetMapping("/IN/{ids}")
	public List<StuModel> getByIdIn(@PathVariable List<Long> ids)
	{
		return stuInterface.findByIdIn(ids);
	}
	
	@PostMapping("/addStu")
	StuModel newUser1(@RequestBody StuModel newUser1)
	{
		return stuInterface.save(newUser1);
	}
	
	@PutMapping("/updateStu/{id}")
	public ResponseEntity<StuModel> updateUser(@PathVariable Long id, @RequestBody StuModel updateUser)
	{
		Optional<StuModel> StuData = stuInterface.findById(id);
		if(StuData.isPresent())
		{
			StuModel user = StuData.get();
			user.setRegno(updateUser.getRegno());
			user.setName(updateUser.getName());
			user.setMarks(updateUser.getMarks());
			stuInterface.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/deleteStu/{id}")
	public ResponseEntity<HttpStatus> deleteuser(@PathVariable Long id)
	{
		try
		{
			stuInterface.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}


