package com.expenseTracker.Controller;

import java.util.List;

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

import com.expenseTracker.Entity.Category;
import com.expenseTracker.Service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController 
{
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<?> addCategory(@RequestBody Category category)
	{
		Category addCategory = categoryService.addCategory(category);
		
		return ResponseEntity.status(HttpStatus.OK).body(addCategory);
	}
	
	@GetMapping("/getAllCategories")
	public ResponseEntity<?> getAllCategories()
	{
		List<Category> allCategories = categoryService.getAllCategories();
		
		return ResponseEntity.status(HttpStatus.OK).body(allCategories);
	}
	
	@GetMapping("/getCategoryById/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable long id)
	{
		Category categoryById = categoryService.getCategoryById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(categoryById);
	}
	
	@GetMapping("/getCategoryByName/{name}")
	public ResponseEntity<?> getCategoryByName(@PathVariable String name)
	{
		Category categoryByName = categoryService.getCategoryByName(name);
		
		return ResponseEntity.status(HttpStatus.OK).body(categoryByName);
	}

	@GetMapping("/getCategoryByType/{type}")
	public ResponseEntity<?> getCategoryByType(@PathVariable String type)
	{
		List<Category> categoryByType = categoryService.getCategoryByType(type);
		
		return ResponseEntity.status(HttpStatus.OK).body(categoryByType);
	}
	
	@PutMapping("/updateCategory/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable long id,@RequestBody Category category)
	{
		Category updatedCategory = categoryService.updateCategory(id, category);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable long id)
	{
		categoryService.deleteCategory(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Category Deleted Successfully");
	}
}
