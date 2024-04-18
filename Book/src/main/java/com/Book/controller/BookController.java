package com.Book.controller;


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

import com.Book.Interface.BookInterface;
import com.Book.model.BookModel;




@RestController
@RequestMapping("/Book")
public class BookController {

	@Autowired
	private BookInterface bookInterface;
	
	
	@GetMapping("/getBook")
	List<BookModel> getAllUsers()
	{
		return bookInterface.findAll();
	}
	
	@GetMapping("/users/{page}/{size}")
	public Page<BookModel> getAllUsers(@PathVariable int page,@PathVariable int size)
	{
		Pageable PageData = PageRequest.of(page, size,Sort.Direction.ASC,"name");
				return bookInterface.findAll(PageData);
	}
	
	@PostMapping("/addBook")
	BookModel newUser1(@RequestBody BookModel newUser1)
	{
		return bookInterface.save(newUser1);
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<BookModel> updateUser(@PathVariable Long id, @RequestBody BookModel updateUser)
	{
		Optional<BookModel> StuData = bookInterface.findById(id);
		if(StuData.isPresent())
		{
			BookModel user = StuData.get();
			user.setName(updateUser.getName());
			user.setAuthor(updateUser.getAuthor());
			bookInterface.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<HttpStatus> deleteuser(@PathVariable Long id)
	{
		try
		{
			bookInterface.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}



