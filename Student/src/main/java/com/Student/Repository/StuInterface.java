package com.Student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Model.StuModel;

public interface StuInterface extends JpaRepository<StuModel, Long>{

	List<StuModel> findByNameAndMarks(String name, Double marks);

	List<StuModel> findByNameOrMarks(String name, Double marks);

	List<StuModel> findByIdIn(List<Long> ids);

}