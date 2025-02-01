package com.ecommerce.Payload;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ecommerce.Entities.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO 
{
	@NotEmpty(message = "Product Name cannot be empty")
	@Size(min = 3,max = 30,message = "Product Name must be between 3 and 30 in length")
	private String productName;
	
	@NotEmpty(message = "Product Description cannot be empty")
	@Size(min = 3,max = 100,message = "Product description must be between 3 and 100 in length")
	private String description;
	
	@NotNull(message = "Product Quantity cannot be null")
	@Min(value = 1,message = "Product Quantity must be atleast 1")
	private int quantity;
	
	@NotNull(message = "Product Price cannot be null")
	@Min(value = 0,message = "Product price must be non-negative")
	private double price;
	
	@NotNull(message = "Product Discount cannot be null")
	@Min(value = 0,message = "Product discount must be non-negative")
	private double discount;
	
	private double specialPrice;
	
	private String image;
	
	@ManyToOne
	private Category category;
}
