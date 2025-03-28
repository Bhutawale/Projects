package com.expenseTracker.Controller;

import java.util.List;

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

import com.expenseTracker.Entity.User;
import com.expenseTracker.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		User savedUser = userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(savedUser);
	}
	
	
	@GetMapping("getUserById/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") long id)
	{
		User userById = userService.getUserById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(userById);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers()
	{
		List<User> allUsers = userService.getAllUsers();
		
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@PathVariable long id,@RequestBody User user)
	{
		User updatedUser = userService.updateUser(id, user);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id)
	{
		userService.deleteUser(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("User Deleted Successfully");
	}
}
