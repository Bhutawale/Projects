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

import com.expenseTracker.Entity.Income;
import com.expenseTracker.Service.IncomeService;

@Controller   //used for testing .jsp page. If want to test api  from postman change to RestController 
@RequestMapping("/api/income")
public class IncomeController 
{
	@Autowired
	private IncomeService incomeService;
	
	@PostMapping("/addIncome/{userId}/{categoryId}/{paymentModeId}")
	public ResponseEntity<?> addIncome
				(@PathVariable long userId,
				@PathVariable long categoryId,
				@PathVariable long paymentModeId,
				@RequestBody Income income)
		{
			Income addIncome = incomeService.addIncome(userId, categoryId, paymentModeId, income);
			
			return ResponseEntity.status(HttpStatus.OK).body(addIncome);
		}
	
	@GetMapping("/incomeByUser/{userId}")
	public ResponseEntity<?> getIncomeByUser(@PathVariable long userId)
	{
		List<Income> incomeByUser = incomeService.getIncomeByUser(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(incomeByUser);
	}
	
	@GetMapping("/incomeByCategory/{categoryName}")
	public ResponseEntity<?> getIncomeByCategory(@PathVariable String categoryName)
	{
		List<Income> incomeByCategory = incomeService.getIncomeByCategory(categoryName);
		
		return ResponseEntity.status(HttpStatus.OK).body(incomeByCategory);
	}
	
	@GetMapping("/incomeByPaymentMode/{paymentId}")
	public ResponseEntity<?> getIncomeByPaymentMode(@PathVariable long paymentId)
	{
		List<Income> incomeByPayment_Mode = incomeService.getIncomeByPayment_Mode(paymentId);
		
		return ResponseEntity.status(HttpStatus.OK).body(incomeByPayment_Mode);
	}
	
	@PutMapping("/updateIncome/{id}")
	public ResponseEntity<?> updateIncome(@PathVariable long id,@RequestBody Income income)
	{
		Income updatedIncome = incomeService.updateIncome(id, income);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedIncome);
	}
	
	@DeleteMapping("/deleteIncome/{id}")
	public ResponseEntity<?> deleteIncome(@PathVariable long id)
	{
		incomeService.deleteIncome(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Income Data Deleted Successfully");
	}
	
	@GetMapping("/getAllIncomes")
	public String getAllIncomes(Model model)
	{
		List<Income> allIncomes = incomeService.getAllIncomes();
		
		model.addAttribute("incomeList",allIncomes);
		
		return "income";
	}
}
