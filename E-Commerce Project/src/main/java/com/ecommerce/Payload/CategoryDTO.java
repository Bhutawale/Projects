package com.ecommerce.Payload;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ecommerce.Entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDTO 
{
	private int categoryId;
	
	@NotEmpty(message = "Category Name cannot be empty.")
	@Size(min = 3,max = 20,message = "Category Name size must be between 3 and 20")
	private String categoryName;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> products;
}
