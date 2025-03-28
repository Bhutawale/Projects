package com.expenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.CustomException.ResourceNotFoundException;
import com.expenseTracker.Dao.UserDao;
import com.expenseTracker.Entity.User;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDao userDao;

	//create User
	public User saveUser(User user) 
	{
		User savedUser = userDao.save(user);
		return savedUser;
	}

	//find user by Id
	public User getUserById(long id) 
	{
		User userById = userDao.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
		return userById;
	}

	//find All Users
	public List<User> getAllUsers() 
	{
		List<User> allUsers = userDao.findAll();
		return allUsers;
	}

	//update user
	public User updateUser(long id, User user) 
	{
		User userToUpdate = userDao.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setIncome(user.getIncome());
		userToUpdate.setExpense(user.getExpense());
		userToUpdate.setBudget(user.getBudget());
		
		User updatedUser = userDao.save(userToUpdate);
		
		return updatedUser;
	}

	// delete user
	public void deleteUser(long id)
	{
		User userToDelete = userDao.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		
		userDao.delete(userToDelete);
	}
	
}
