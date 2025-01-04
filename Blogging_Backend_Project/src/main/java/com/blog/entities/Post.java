package com.blog.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Post 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 100)
	@NotEmpty(message = "Post Title cannot be empty.")
	@Size(min = 5,max = 30,message = "Post title size must be between 5 and 30.")
	private String title;
	
	@Column(length = 10000)
	@NotEmpty(message = "Post Content cannot be empty.")
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
	private List<Comments> comments;
}
