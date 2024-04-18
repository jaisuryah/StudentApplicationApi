package com.sample_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class controller 
{
	@GetMapping("/skct/add/{a}/{b}")
	public Integer add(@PathVariable Integer a, @PathVariable Integer b){
		return a+b;
	}
	@GetMapping("/skct/sub/{a}/{b}")
	public Integer sub(@PathVariable Integer a, @PathVariable Integer b){
		return a-b;
	}
	@GetMapping("/skct/mul/{a}/{b}")
	public Integer mul(@PathVariable Integer a, @PathVariable Integer b){
		return a*b;
	}
	@GetMapping("/skct/div/{a}/{b}")
	public Integer div(@PathVariable Integer a, @PathVariable Integer b){
		return a/b;
	}

	@GetMapping("/skct/pow/{a}/{b}")
	public Integer pow(@PathVariable Integer a, @PathVariable Integer b)
	{
		return (int) Math.pow(a, b);
	}
}
