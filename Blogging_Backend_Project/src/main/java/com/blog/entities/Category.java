package com.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Category Name cannot be empty.")
	@Size(min = 3,max = 100,message = "Category Name size must be between 3 and 15.")
	private String catName;
	
	@NotEmpty(message = "Categoty Description cannot be empty.")
	@Size(min = 3,max = 200,message = "Category Description size must be between 3 and 15.")
	private String catDescription;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Post> post=new ArrayList<Post>();
}
