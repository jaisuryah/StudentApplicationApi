package com.String;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	@RequestMapping("/homeString")
	public String getch()
	{
		return "Hello World!";
	}
}
