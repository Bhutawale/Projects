package com.blog.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Name Field cannot be empty.")
	@Size(min = 3,max = 15,message = "Name size must be between 3 and 15.")
	private String name;
	
	@NotEmpty(message = "Email Field cannot be empty.")
	@Email
	private String email;
	
	@NotEmpty(message = "Password Field cannot be empty.")
	@Size(min = 3,max = 15,message = "Password size must be between 3 and 15.")
	private String password;
	
	@NotEmpty
	(message = "About Field cannot be empty.")
	@Size(min = 3,max = 100,message = "About size must be between 3 and 100.")
	private String about;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="user")
	@JsonIgnore
	private List<Post> post;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	@JsonIgnore
	private List<Comments> comment;
}
