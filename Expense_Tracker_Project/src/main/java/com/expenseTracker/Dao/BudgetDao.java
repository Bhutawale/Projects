package com.expenseTracker.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseTracker.Entity.Budget;
import com.expenseTracker.Entity.Category;
import com.expenseTracker.Entity.User;

@Repository
public interface BudgetDao extends JpaRepository<Budget, Long> 
{
	List<Budget> findByUser(User user);
	
	List<Budget> findByCategory(Category category);
}
