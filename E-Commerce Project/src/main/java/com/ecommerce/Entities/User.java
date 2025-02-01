package com.ecommerce.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(uniqueConstraints = {
								@UniqueConstraint(columnNames = "userName"),
								@UniqueConstraint(columnNames = "email")
								})
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	private String email;
	
	private String password;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Roles> roles=new HashSet<>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<Product> products;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Address> address=new ArrayList<Address>();
	
	public User(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	
}
