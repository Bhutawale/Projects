package com.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.User;
import com.blog.services.UserServiceI;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	private UserServiceI  userservice;
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user)
	{
		User saveUser = userservice.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> findUserById(@PathVariable("id") int id)
	{
		User userById = userservice.findUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(userById);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> findAllUsers()
	{
		List<User> allUsers = userservice.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable int id)
	{
		User updatedUser = userservice.updateUser(user, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id)
	{
		userservice.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
	}
}
