package com.expenseTracker.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseTracker.Entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> 
{

}
