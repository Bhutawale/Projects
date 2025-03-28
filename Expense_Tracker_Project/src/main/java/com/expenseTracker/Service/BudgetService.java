package com.expenseTracker.Service;

import java.util.List;

import com.expenseTracker.Entity.Budget;

public interface BudgetService 
{
	Budget addBudget(long userId,long categoryId,Budget budget);
	
	Budget updateBudget(long id,Budget budget);
	
	void deleteBudget(long id);
	
	List<Budget> getBudgetByUser(long userId);
	
	List<Budget> getBudgetByCategory(long categoryId);
}
