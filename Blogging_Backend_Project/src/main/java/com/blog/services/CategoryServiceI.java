package com.blog.services;

import java.util.List;

import com.blog.entities.Category;

public interface CategoryServiceI 
{
	public Category saveCategory(Category category);
	
	public Category findCategoryById(int id);
	
	public List<Category> findAllCategories();
	
	public Category updateCategory(Category category, int id);
	
	public void deleteCategory(int id);
}
