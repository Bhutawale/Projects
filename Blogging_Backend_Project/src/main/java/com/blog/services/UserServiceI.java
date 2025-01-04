package com.blog.services;

import java.util.List;

import com.blog.entities.User;


public interface UserServiceI 
{
	public User saveUser(User user);
	
	public User findUserById(int id);
	
	public List<User> findAllUsers();
	
	public User updateUser(User user,int id);
	
	public void deleteUser(int id);
}
