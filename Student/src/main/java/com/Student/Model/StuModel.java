package com.Student.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
public class StuModel {
@Id
@GeneratedValue
	private Long id;
	private String regno;
	private String name;
	private Double marks;
	@Transient
	private Integer age;
	
	public Integer getAge() {
		if(this.marks < 200)
		{
			return 20;
		}
		else if(this.marks>=200 && this.marks <= 500)
		{
			return 30;
		}
		else
		{
			return 40;
		}
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMarks() {
		return marks;
	}
	public void setMarks(Double marks) {
		this.marks = marks;
	}
	
}
