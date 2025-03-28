package com.expenseTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expenseTracker.Entity.Expense;
import com.expenseTracker.Entity.Income;
import com.expenseTracker.Service.ExpenseService;
import com.expenseTracker.Service.IncomeService;

@Controller
@RequestMapping("/api")
public class HomeController 
{
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private ExpenseService expenseService;
	
 	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/summary")
	public String summary(Model model)
	{
		List<Income> incomeList = incomeService.getAllIncomes();
        List<Expense> expenseList = expenseService.getAllExpenses();

        // Calculate totals
        double totalIncome = incomeList.stream().mapToDouble(Income::getAmount).sum();
        double totalExpense = expenseList.stream().mapToDouble(Expense::getAmount).sum();
        double remainingBalance = totalIncome - totalExpense;

        // Add data to model
        model.addAttribute("incomeList", incomeList);
        model.addAttribute("expenseList", expenseList);
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("remainingBalance", remainingBalance);
		
        return "summary";
	}
}
