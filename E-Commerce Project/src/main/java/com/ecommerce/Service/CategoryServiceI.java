package com.ecommerce.Service;

import javax.validation.Valid;

import com.ecommerce.Pagination.CategoryResponse;
import com.ecommerce.Payload.CategoryDTO;

public interface CategoryServiceI 
{
	public CategoryDTO createCategory(CategoryDTO categoryDto);
	
	public CategoryDTO getCategoryById(int categoryId);
	
	public CategoryResponse getAllCategories(int pageNumber,int pageSize,String sortBy);
	
	public void deleteCategory(int categoryId);
	
	public CategoryDTO updateCategory(@Valid CategoryDTO category,int cateoryId);
}
