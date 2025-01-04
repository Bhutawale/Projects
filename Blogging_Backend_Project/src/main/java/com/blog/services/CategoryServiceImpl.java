package com.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repositories.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryServiceI
{

	@Autowired
	private CategoryDao catDao;
	
	public Category saveCategory(Category category) 
	{
		Category saveCategory = catDao.save(category);
		return saveCategory;
	}

	public Category findCategoryById(int id) 
	{
		Category categoryById = catDao.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Category with given Id "+ id+" does not exist."));
		return categoryById;
	}

	@Override
	public List<Category> findAllCategories() 
	{
		List<Category> allCategories = catDao.findAll();
		return allCategories;
	}

	@Override
	public Category updateCategory(Category category, int id) 
	{
		Category categoryById = catDao.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Category with given Id "+ id+" does not exist."));
		
		categoryById.setCatName(category.getCatName());
		categoryById.setCatDescription(category.getCatDescription());
		
		Category updatedCategory = catDao.save(categoryById);
		
		return updatedCategory;
	}

	@Override
	public void deleteCategory(int id) 
	{
		catDao.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Category with given Id "+ id+" does not exist."));
		
		catDao.deleteById(id);
	}

}
