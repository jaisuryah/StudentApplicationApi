package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.user;

public interface userRepository  extends JpaRepository<user, Long>{
           List<user>findAl();
}