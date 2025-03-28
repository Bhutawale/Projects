package com.expenseTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expenseTracker.Entity.Expense;
import com.expenseTracker.Service.ExpenseService;

@Controller //used for testing .jsp page. If want to test api  from postman change to RestController 
@RequestMapping("/api/expense")
public class ExpenseController 
{
	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping("/addExpense/{userId}/{categoryId}/{paymentModeId}")
	public ResponseEntity<?> addExpense
				(@PathVariable long userId,
				@PathVariable long categoryId,
				@PathVariable long paymentModeId,
				@RequestBody Expense expense)
		{
			Expense addExpense = expenseService.addExpense(userId, categoryId, paymentModeId, expense);
			
			return ResponseEntity.status(HttpStatus.OK).body(addExpense);
		}
	
	@GetMapping("/expenseByUser/{userId}")
	public ResponseEntity<?> getExpenseByUser(@PathVariable long userId)
	{
		List<Expense> expenseByUser = expenseService.getExpenseByUser(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseByUser);
	}
	
	
	@GetMapping("/expenseByCategory/{categoryName}")
	public ResponseEntity<?> getExpenseByCategory(@PathVariable String categoryName)
	{
		List<Expense> expenseByCategory = expenseService.getExpenseByCategory(categoryName);
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseByCategory);
	}
	
	@GetMapping("/expenseByPaymentMode/{paymentId}")
	public ResponseEntity<?> getExpenseByPaymentMode(@PathVariable long paymentId)
	{
		List<Expense> expenseByPayment_Mode = expenseService.getExpenseByPayment_Mode(paymentId);
		
		return ResponseEntity.status(HttpStatus.OK).body(expenseByPayment_Mode);
	}
	
	@PutMapping("/updateExpense/{id}")
	public ResponseEntity<?> updateExpense(@PathVariable long id,@RequestBody Expense expense)
	{
		Expense updatedExpense = expenseService.updateExpense(id, expense);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedExpense);
	}
	
	@DeleteMapping("/deleteExpense/{id}")
	public ResponseEntity<?> deleteExpense(@PathVariable long id)
	{
		expenseService.deleteExpense(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Expense Data Deleted Successfully");
	}
	
	@GetMapping("/getAllExpenses")
	public String getAllExpenses(Model model)
	{
		List<Expense> allExpenses = expenseService.getAllExpenses();
		
		model.addAttribute("expenseList", allExpenses);
		
		return "expense";
	}
}
