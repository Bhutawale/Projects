package com.ecommerce.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	private String street;
	
	private String buildingName;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> user;

	public Address(String street, String buildingName, String city, String state, String country, String pincode) {
		super();
		this.street = street;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	
}
