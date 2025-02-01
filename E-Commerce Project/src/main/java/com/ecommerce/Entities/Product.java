package com.ecommerce.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	
	private String productName;
	
	private String description;
	
	private int quantity;
	
	private double price;
	
	private double discount;
	
	private double specialPrice;
	
	private String image;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private User user;
}
