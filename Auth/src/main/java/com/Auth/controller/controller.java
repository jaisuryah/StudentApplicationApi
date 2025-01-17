package com.Auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Auth.Interface.AuthInterface;
import com.Auth.model.Model;


@RestController
@RequestMapping("/api/auth")
public class controller{

    @Autowired
    private AuthInterface authInterface;

    @PostMapping("/register")
    public String registerStaff(@RequestBody Model registerStaff) {
    	authInterface.save(registerStaff);
        return "Staff registered successfully";
    }

    @GetMapping("/login")
    public String login(@RequestParam String user, @RequestParam String pass) {
        Model staff = authInterface.findByUser(user);
        if (staff == null) {
            return "User not found";
        } else if (staff.getPass().equals(pass)) {
            return "Login successful";
        } else {	
            return "Incorrect password";
        }
    }
}
