package com.expenseTracker.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseTracker.Entity.Category;
import com.expenseTracker.Entity.Expense;
import com.expenseTracker.Entity.Payment_Mode;
import com.expenseTracker.Entity.User;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long> 
{
		// Get all expense records for a specific user
		List<Expense> findByUser(User user);
		
		 // Get all expense records for a specific category
		List<Expense> findByCategory(Category category);
		
		 // Get all expense records by payment mode
		List<Expense> findByPayment(Payment_Mode payment_Mode);
}
