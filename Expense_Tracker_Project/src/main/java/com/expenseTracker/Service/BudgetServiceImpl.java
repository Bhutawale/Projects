package com.expenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.CustomException.ResourceNotFoundException;
import com.expenseTracker.Dao.BudgetDao;
import com.expenseTracker.Dao.CategoryDao;
import com.expenseTracker.Dao.UserDao;
import com.expenseTracker.Entity.Budget;
import com.expenseTracker.Entity.Category;
import com.expenseTracker.Entity.User;

@Service
public class BudgetServiceImpl implements BudgetService
{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private BudgetDao budgetDao;
	
	
	public Budget addBudget(long userId, long categoryId, Budget budget) 
	{
		User user = userDao.findById(userId)
					.orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		
		Category category = categoryDao.findById(categoryId)
					.orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		
		budget.setUser(user);
		
		budget.setCategory(category);
		
		Budget addBudget = budgetDao.save(budget);
		
		return addBudget;
	}

	
	public Budget updateBudget(long id, Budget budget) 
	{
		Budget existingBudget = budgetDao.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Budget Not Found"));
		
		existingBudget.setAmount(budget.getAmount());
		existingBudget.setMonth(budget.getMonth());
		existingBudget.setYear(budget.getYear());
		
		if(budget.getUser()!=null)
		{
			User user = userDao.findById(budget.getUser().getId())
				.orElseThrow(()->new ResourceNotFoundException("User Not Found"));
			
			existingBudget.setUser(user);
		}
		
		if(budget.getCategory()!=null)
		{
			Category category = categoryDao.findById(budget.getCategory().getId())
				.orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
			
			existingBudget.setCategory(category);
		}
		
		Budget updatedBudget = budgetDao.save(existingBudget);
		
		return updatedBudget;
	}

	
	public void deleteBudget(long id) 
	{
		Budget budget = budgetDao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Budget Not Found"));
		
		budgetDao.delete(budget);
	}


	public List<Budget> getBudgetByUser(long userId) 
	{
		User user = userDao.findById(userId)
			.orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		
		List<Budget> budgetByUser = budgetDao.findByUser(user);
		
		return budgetByUser;
	}

	
	public List<Budget> getBudgetByCategory(long categoryId) 
	{
		Category category = categoryDao.findById(categoryId)
					.orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		
		List<Budget> budgetByCategory = budgetDao.findByCategory(category);
		
		return budgetByCategory;
	}
	
}
