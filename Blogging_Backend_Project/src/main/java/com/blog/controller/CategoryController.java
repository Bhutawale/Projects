package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.Category;
import com.blog.services.CategoryServiceI;

@RestController
@RequestMapping("/api/category")
public class CategoryController
{
	@Autowired
	private CategoryServiceI catService;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<?> saveCategory(@Valid @RequestBody Category category)
	{
		Category saveCategory = catService.saveCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body(saveCategory);
	}
	
	@GetMapping("/findCategoryById/{id}")
	public ResponseEntity<?> findCategoryById(@PathVariable int id)
	{
		Category categoryById = catService.findCategoryById(id);
		return ResponseEntity.status(HttpStatus.OK).body(categoryById);
	}
	
	@GetMapping("/findAllCategories")
	public ResponseEntity<?> findAllCategories()
	{
		List<Category> allCategories = catService.findAllCategories();
		return ResponseEntity.status(HttpStatus.OK).body(allCategories);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable int id)
	{
		catService.deleteCategory(id);
		return ResponseEntity.status(HttpStatus.OK).body("Category Deleted Successfully.");
	}
	
	@PutMapping("/updateCategory/{id}")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody Category category,@PathVariable int id)
	{
		Category updatedCategory = catService.updateCategory(category, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
	}
}
