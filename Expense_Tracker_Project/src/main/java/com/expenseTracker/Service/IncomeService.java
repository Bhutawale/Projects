package com.expenseTracker.Service;

import java.util.List;

import com.expenseTracker.Entity.Income;

public interface IncomeService 
{
	Income addIncome(long userId,long categoryId,long paymentModeId,Income income);
	
	void deleteIncome(long id);
	
	Income updateIncome(long id,Income income);
	
	List<Income> getIncomeByUser(long userId);
	
	List<Income> getIncomeByCategory(String categoryName);
	
	List<Income> getIncomeByPayment_Mode(long paymentId);
	
	List<Income> getAllIncomes();
}
