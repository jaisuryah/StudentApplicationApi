package com.Book.Interface;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Book.model.BookModel;


public interface BookInterface extends JpaRepository<BookModel, Long>{

	

}