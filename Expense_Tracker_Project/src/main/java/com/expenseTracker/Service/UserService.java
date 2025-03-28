package com.expenseTracker.Service;

import java.util.List;

import com.expenseTracker.Entity.User;

public interface UserService 
{
	User saveUser(User user);
	
	User getUserById(long id);
	
	List<User> getAllUsers();
	
	User updateUser(long id,User user);
	
	void deleteUser(long id);
}
