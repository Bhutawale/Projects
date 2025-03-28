package com.expenseTracker.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseTracker.Entity.Payment_Mode;

@Repository
public interface Payment_ModeDao extends JpaRepository<Payment_Mode, Long> 
{

}
