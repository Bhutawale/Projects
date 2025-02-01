package com.ecommerce.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ApplicationConstants.AppConstants;
import com.ecommerce.Pagination.CategoryResponse;
import com.ecommerce.Payload.CategoryDTO;
import com.ecommerce.Service.CategoryServiceI;

@RestController
@RequestMapping("/api")
public class CategoryController 
{
	@Autowired
	private CategoryServiceI categoryService;
	
	@PostMapping("/admin/createCategory")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDto)
	{
		CategoryDTO saveCategory = categoryService.createCategory(categoryDto);
		return ResponseEntity.status(HttpStatus.OK).body(saveCategory);
	}
	
	@GetMapping("/public/findCategoryById/{categoryId}")
	public ResponseEntity<?> findCategoryById(@PathVariable int categoryId)
	{
		CategoryDTO categoryById = categoryService.getCategoryById(categoryId);
		return ResponseEntity.status(HttpStatus.OK).body(categoryById);
	}
	
	@GetMapping("/public/findAllCategories")
	public ResponseEntity<?> findAllCategories(
			@RequestParam(name = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER) int pageNumber,
			@RequestParam(name = "pageSize",defaultValue = AppConstants.PAGE_SIZE) int pageSize,
			@RequestParam(name = "sortBy",defaultValue = AppConstants.SORTBY)String sortBy)
	{
		CategoryResponse allCategories = categoryService.getAllCategories(pageNumber,pageSize,sortBy);
		return ResponseEntity.status(HttpStatus.OK).body(allCategories);
	}
	
	@DeleteMapping("/admin/deleteCategory/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable int categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.OK).body("Category with given Id Deleted Successfully.");
	}
	
	@PutMapping("/admin/updateCategory/{categoryId}")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDTO categoryDto,@PathVariable int categoryId)
	{
		CategoryDTO updatedCategory = categoryService.updateCategory(categoryDto, categoryId);
		return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
	}
}
