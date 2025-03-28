package com.expenseTracker.Service;

import java.util.List;

import com.expenseTracker.Entity.Category;

public interface CategoryService 
{
	Category addCategory(Category category);
	
	List<Category> getAllCategories();
	
	Category getCategoryById(long id);
	
	Category getCategoryByName(String name);
	
	List<Category> getCategoryByType(String type); // based on income/expense
	
	Category updateCategory(long id,Category category);
	
	void deleteCategory(long id);
}
