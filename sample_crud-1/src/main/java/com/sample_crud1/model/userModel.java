package com.sample_crud1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name="Table3")
public class userModel {
@Id
@GeneratedValue
	private long id;
	private String name;
	@Transient
	private Integer age;
	private Double income;
	
	//@OneToOne(cascade = CascadeType.ALL)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="details")
	
	
	private List<userDetail> detail;
	//private userDetail userDetail;
//	public userDetail getUserDetail() {
//		return userDetail;
//	}
//	public void setUserDetail(userDetail userDetail) {
//		this.userDetail = userDetail;
//	}
	
	
	public List<userDetail> getDetail() {
		return detail;
	}
	public void setDetail(List<userDetail> detail) {
		this.detail = detail;
	}
	
	public Integer getAge() {
		if(this.income < 2000)
		{
			return 20;
		}
		else if(this.income>=2000 && this.income <= 5000)
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	
	
}
