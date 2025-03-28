package com.expenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.CustomException.ResourceNotFoundException;
import com.expenseTracker.Dao.CategoryDao;
import com.expenseTracker.Entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryDao categoryDao;
	
	public Category addCategory(Category category) 
	{
		Category savedCategory = categoryDao.save(category);
		return savedCategory;
	}


	public List<Category> getAllCategories() 
	{
		List<Category> allCategories = categoryDao.findAll();
		return allCategories;
	}

	public Category getCategoryById(long id) 
	{
		Category categoryById = categoryDao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		return categoryById;
	}

	public Category getCategoryByName(String name) 
	{
		Category categoryByName = categoryDao.findByName(name);
		if(categoryByName!=null)
		{
			return categoryByName;
		}
		else
		{
			throw new ResourceNotFoundException("Category with given name not found");
		}
	}

	public List<Category> getCategoryByType(String type)
	{
		List<Category> categoryByType = categoryDao.findByType(type);
		if(categoryByType!=null)
		{
			return categoryByType;
		}
		else
		{
			throw new ResourceNotFoundException("Category with given name not found");
		}
	}

	public Category updateCategory(long id, Category category)
	{
		Category categoryToUpdate = categoryDao.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("Category with given Id not found"));
		
		categoryToUpdate.setName(category.getName());
		categoryToUpdate.setType(category.getType());
		
		Category updatedCategory = categoryDao.save(categoryToUpdate);
		
		return updatedCategory;
	}


	public void deleteCategory(long id) 
	{
		Category categoryById = categoryDao.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("Category Id Not Found"));
		
		categoryDao.delete(categoryById);
	}
	
}
