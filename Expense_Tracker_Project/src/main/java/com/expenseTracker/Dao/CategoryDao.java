package com.expenseTracker.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseTracker.Entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> 
{
	Category findByName(String name);
	
	List<Category> findByType(String type); // Income/Expense
}
