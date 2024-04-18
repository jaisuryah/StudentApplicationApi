package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.user;
import repository.userRepository;

@RestController
@RequestMapping("/userclass")
public class controller {
	@Autowired
	 private userRepository userRepository;
	 
	@GetMapping("/user")
	List<user>getAllUsers()
	{
		return userRepository.findAll();
	}
	
	@PostMapping("/adduser")
	user newuser(@RequestBody user newUser) {
		return userRepository.save(newUser);
	}
	
	

}