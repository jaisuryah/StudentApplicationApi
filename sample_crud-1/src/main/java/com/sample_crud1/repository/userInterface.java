package com.sample_crud1.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample_crud1.model.userModel;

public interface userInterface extends JpaRepository<userModel, Long>{

	@Query("Select a from userModel a where a.id between :sid and :eid")
	List<userModel> FindByInQuery(Long sid, Long eid);
           //List<userModel>findAl();
}