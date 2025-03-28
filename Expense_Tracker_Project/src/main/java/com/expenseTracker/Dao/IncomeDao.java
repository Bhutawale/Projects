package com.expenseTracker.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseTracker.Entity.Category;
import com.expenseTracker.Entity.Income;
import com.expenseTracker.Entity.Payment_Mode;
import com.expenseTracker.Entity.User;

@Repository
public interface IncomeDao extends JpaRepository<Income, Long>
{	
	// Get all income records for a specific user
	List<Income> findByUser(User user);
	
	 // Get all income records for a specific category
	List<Income> findByCategory(Category category);
	
	 // Get all income records by payment mode
	List<Income> findByPayment(Payment_Mode payment_Mode);
}
