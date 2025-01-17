package com.Club.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Club.Model.Club;
public interface ClubInterface extends JpaRepository<Club, Long> {

	Optional<Club> findByName(String name);

	void deleteByName(String name);
}
