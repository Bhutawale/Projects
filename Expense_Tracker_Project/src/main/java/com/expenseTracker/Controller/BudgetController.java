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

import com.expenseTracker.Entity.Budget;
import com.expenseTracker.Service.BudgetService;

@RestController
@RequestMapping("/api/budget")
public class BudgetController 
{
	@Autowired
	private BudgetService budgetService;
	
	@PostMapping("/addBudget/{userId}/{categoryId}")
	public ResponseEntity<?> addBudget(
			@PathVariable long userId,
			@PathVariable long categoryId,
			@RequestBody Budget budget)
	{
		Budget addBudget = budgetService.addBudget(userId, categoryId, budget);
		
		return ResponseEntity.status(HttpStatus.OK).body(addBudget);
	}
	
	@PutMapping("/updateBudget/{id}")
	public ResponseEntity<?> updateBudget(@PathVariable long id,@RequestBody Budget budget)
	{
		Budget updatedBudget = budgetService.updateBudget(id, budget);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedBudget);
	}
	
	@DeleteMapping("/deleteBudget/{id}")
	public ResponseEntity<?> deleteBudget(@PathVariable long id)
	{
		budgetService.deleteBudget(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Budget Deleted Successfully");
	}
	
	@GetMapping("/getBudgetByUser/{userId}")
	public ResponseEntity<?> getBudgetByUser(@PathVariable long userId)
	{
		List<Budget> budgetByUser = budgetService.getBudgetByUser(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(budgetByUser);
	}
	
	@GetMapping("/getBudgetByCategory/{categoryId}")
	public ResponseEntity<?> getBudgetByCategory(@PathVariable long categoryId)
	{
		List<Budget> budgetByCategory = budgetService.getBudgetByCategory(categoryId);
		
		return ResponseEntity.status(HttpStatus.OK).body(budgetByCategory);
	}
}
