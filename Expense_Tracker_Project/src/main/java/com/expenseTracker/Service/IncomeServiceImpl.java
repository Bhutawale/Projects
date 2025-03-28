package com.expenseTracker.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.CustomException.ResourceNotFoundException;
import com.expenseTracker.Dao.CategoryDao;
import com.expenseTracker.Dao.IncomeDao;
import com.expenseTracker.Dao.Payment_ModeDao;
import com.expenseTracker.Dao.UserDao;
import com.expenseTracker.Entity.Category;
import com.expenseTracker.Entity.Income;
import com.expenseTracker.Entity.Payment_Mode;
import com.expenseTracker.Entity.User;

@Service
public class IncomeServiceImpl implements IncomeService
{
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private Payment_ModeDao paymentDao;
	
	@Autowired
	private IncomeDao incomeDao;
	
	//add Income
	
	public Income addIncome(long userId, long categoryId, long paymentModeId, Income income) 
	{
		User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		Category category = categoryDao.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		Payment_Mode paymentMode = paymentDao.findById(paymentModeId).orElseThrow(()->new ResourceNotFoundException("Payment Mode Not Found"));
		
			income.setUser(user);
			income.setCategory(category);
			income.setPayment(paymentMode);
			
			income.setDate(LocalDate.now());
			
			Income savedIncome = incomeDao.save(income);
			
			return savedIncome;
		
	}
	
	//delete income
	public void deleteIncome(long id) 
	{
		incomeDao.deleteById(id);
	}

	//update income
	public Income updateIncome(long id, Income income) 
	{
		Income incomeToUpdate = incomeDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Income Not Found"));
		
		incomeToUpdate.setAmount(income.getAmount());
		incomeToUpdate.setDate(LocalDate.now());
		incomeToUpdate.setDescription(income.getDescription());
		
		if(income.getCategory()!=null) 
		{
			Category category = categoryDao.findById(income.getCategory().getId()).orElseThrow(()->new ResourceNotFoundException("Category Not Found"));
		
			incomeToUpdate.setCategory(category);
		}
		
		if(income.getPayment()!=null)
		{
			Payment_Mode payment_Mode = paymentDao.findById(income.getPayment().getId()).orElseThrow(()->new ResourceNotFoundException("Payment Mode Not Found"));
			
			incomeToUpdate.setPayment(payment_Mode);
		}
		
		
		Income updatedIncome = incomeDao.save(incomeToUpdate);
		
		return updatedIncome;
	}


	public List<Income> getIncomeByUser(long userId) 
	{
		User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		
		List<Income> incomeByUser = incomeDao.findByUser(user);
		
		return incomeByUser;
	}

	
	public List<Income> getIncomeByCategory(String categoryName) 
	{
		Category category = categoryDao.findByName(categoryName);
		List<Income> incomeByCategory = incomeDao.findByCategory(category);
		return incomeByCategory;
		
	}


	public List<Income> getIncomeByPayment_Mode(long paymentId) 
	{
		Payment_Mode payment_Mode = paymentDao.findById(paymentId).orElseThrow(()->new ResourceNotFoundException("Payment Not Found"));
		
		List<Income> incomeByPaymentMode = incomeDao.findByPayment(payment_Mode);
		
		return incomeByPaymentMode;
	}

	public List<Income> getAllIncomes() 
	{
		List<Income> findAllIncomes = incomeDao.findAll();
		return findAllIncomes;
	}	
}
