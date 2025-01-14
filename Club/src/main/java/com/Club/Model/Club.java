package com.Club.Model;

import java.util.ArrayList; 
import java.util.List;

import jakarta.persistence.CascadeType; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Club 
{
	@Id

	@GeneratedValue

	private Long id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "club_id")

	private List<Member> members = new ArrayList<>();

	public Long getId() {
			return id;
	}
	

	public void setId(Long id) { this.id = id;}
public String getName() {
return name;
}
public void setName(String name) { this.name = name;
}
public List<Member> getMembers() { return members;
}
 
public void setMembers(List<Member> members) { this.members = members;
}}
