package com.expenseTracker.Service;

import java.util.List;

import com.expenseTracker.Entity.Expense;

public interface ExpenseService 
{
	Expense addExpense(long userId,long categoryId,long paymentModeId,Expense expense);
	
	void deleteExpense(long id);
	
	Expense updateExpense(long id,Expense expense);
	
	List<Expense> getExpenseByUser(long userId);
	
	List<Expense> getExpenseByCategory(String categoryName);
	
	List<Expense> getExpenseByPayment_Mode(long paymentId);
	
	List<Expense> getAllExpenses();
}
