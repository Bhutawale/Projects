package com.expenseTracker.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.CustomException.ResourceNotFoundException;
import com.expenseTracker.Dao.CategoryDao;
import com.expenseTracker.Dao.ExpenseDao;
import com.expenseTracker.Dao.Payment_ModeDao;
import com.expenseTracker.Dao.UserDao;
import com.expenseTracker.Entity.Category;
import com.expenseTracker.Entity.Expense;
import com.expenseTracker.Entity.Payment_Mode;
import com.expenseTracker.Entity.User;

@Service
public class ExpenseServiceImpl implements ExpenseService
{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private Payment_ModeDao paymentDao;
	
	@Autowired
	private ExpenseDao expenseDao;
	

	public Expense addExpense(long userId, long categoryId, long paymentModeId, Expense expense)
	{
		User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		Category category = categoryDao.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		Payment_Mode paymentMode = paymentDao.findById(paymentModeId).orElseThrow(()->new ResourceNotFoundException("Payment Mode Not Found"));
		
			expense.setUser(user);
			expense.setCategory(category);
			expense.setPayment(paymentMode);
			
			expense.setDate(LocalDate.now());
			
			Expense savedexpense = expenseDao.save(expense);
			
			return savedexpense;
		
	}

	public void deleteExpense(long id) 
	{
		expenseDao.deleteById(id);
	}


	public Expense updateExpense(long id, Expense expense) 
	{
		Expense expenseToUpdate = expenseDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Income Not Found"));
		
		expenseToUpdate.setAmount(expense.getAmount());
		expenseToUpdate.setDate(LocalDate.now());
		expenseToUpdate.setDescription(expense.getDescription());
		
		if(expense.getCategory()!=null) 
		{
			Category category = categoryDao.findById(expense.getCategory().getId()).orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		
			expenseToUpdate.setCategory(category);
		}
		
		if(expense.getPayment()!=null)
		{
			Payment_Mode payment_Mode = paymentDao.findById(expense.getPayment().getId()).orElseThrow(()->new ResourceNotFoundException("Payment Mode Not Found"));
			
			expenseToUpdate.setPayment(payment_Mode);
		}
		
		
		Expense updatedexpense = expenseDao.save(expenseToUpdate);
		
		return updatedexpense;
	}


	public List<Expense> getExpenseByUser(long userId) 
	{
		User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		
		List<Expense> expenseByUser = expenseDao.findByUser(user);
		
		return expenseByUser;
	}

	
	public List<Expense> getExpenseByCategory(String categoryName) 
	{
		Category category = categoryDao.findByName(categoryName);
		List<Expense> expenseByCategory = expenseDao.findByCategory(category);
		return expenseByCategory;
	}


	public List<Expense> getExpenseByPayment_Mode(long paymentId) 
	{
		Payment_Mode payment_Mode = paymentDao.findById(paymentId).orElseThrow(()->new ResourceNotFoundException("Payment Not Found"));
		
		List<Expense> expenseByPaymentMode = expenseDao.findByPayment(payment_Mode);
		
		return expenseByPaymentMode;
	}


	public List<Expense> getAllExpenses() 
	{
		List<Expense> findAllExpenses = expenseDao.findAll();
		return findAllExpenses;
	}
	
}
