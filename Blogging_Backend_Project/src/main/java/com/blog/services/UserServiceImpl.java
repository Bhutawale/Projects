package com.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repositories.UserDao;

@Service
public class UserServiceImpl implements UserServiceI 
{
	@Autowired
	private UserDao userdao;
	
	public User saveUser(User user) 
	{
		User saveUser = userdao.save(user);
		return saveUser;
	}

	public User findUserById(int id) 
	{
		User userById = userdao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("User with given Id "+id +" does not exist"));
		return userById;
	}

	public List<User> findAllUsers() 
	{
		List<User> allUsers = userdao.findAll();
		return allUsers;
	}

	public User updateUser(User user, int id) 
	{
		User userById = userdao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("User with given Id "+id +" does not exist"));
		
		userById.setName(user.getName());
		userById.setEmail(user.getEmail());
		userById.setPassword(user.getPassword());
		userById.setAbout(user.getAbout());
		
		User updatedUser = userdao.save(userById);
		
		return updatedUser;
	}

	public void deleteUser(int id) 
	{
		userdao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("User with given Id "+id +" does not exist"));
		
		userdao.deleteById(id);
	}
	
}
