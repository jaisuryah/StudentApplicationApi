package com.Auth.Interface;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Auth.model.Model;

public interface AuthInterface extends JpaRepository<Model, Integer> {

    Model findByUser(String user);
}
