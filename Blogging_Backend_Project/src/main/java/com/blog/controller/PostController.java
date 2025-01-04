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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Pagination.PageResponse;
import com.blog.config.ApplicationConstants;
import com.blog.entities.Post;
import com.blog.services.PostServiceI;

@RestController
@RequestMapping("/api")
public class PostController 
{
	@Autowired
	private PostServiceI postService;
	
	@PostMapping("/user/{userId}/category/{catId}/savePost")
	public ResponseEntity<?> createPost
				(@Valid @RequestBody Post post,@PathVariable int userId,@PathVariable int catId)
	{
		Post createPost = postService.createPost(post, userId, catId);
		
		return ResponseEntity.status(HttpStatus.OK).body(createPost);
	}
	
	@DeleteMapping("/post/deletePost/{id}")
	public ResponseEntity<?> deletePost(@PathVariable int id)
	{
		postService.deletePost(id);
		return ResponseEntity.status(HttpStatus.OK).body("Post deleted Successfully.");
	}
	
	@GetMapping("/post/findById/{id}")
	public ResponseEntity<?> findPostById(@PathVariable int id)
	{
		Post postById = postService.findPostById(id);
		return ResponseEntity.status(HttpStatus.OK).body(postById);
	}
	
	
	@GetMapping("/post/findAllPosts")
	public ResponseEntity<?> findAllPosts(
			@RequestParam(value = "pageNumber",defaultValue = ApplicationConstants.PAGE_NUMBER,required =false ) int pageNo,
			@RequestParam(value = "pageSize",defaultValue = ApplicationConstants.PAGE_SIZE,required = false) int pageSize,
			@RequestParam(value = "sortBy",defaultValue = ApplicationConstants.SORT_BY,required = false) String sortBy
			)
	{
		PageResponse pageResponse = postService.findAllPosts(pageNo,pageSize,sortBy);
		return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
	}
	
	@PutMapping("/post/updatePost/{id}")
	public ResponseEntity<?> updatePost(@RequestBody Post post,@PathVariable int id)
	{
		Post updatedPost = postService.updatePost(post, id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
	}
	
	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<?> findPostByCategory(@PathVariable int catId)
	{
		List<Post> findPostByCategory = postService.findPostByCategory(catId);
		return ResponseEntity.status(HttpStatus.OK).body(findPostByCategory);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<?> findPostByUser(@PathVariable int userId)
	{
		List<Post> findPostByUser = postService.findPostByUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(findPostByUser);
	}
	
	@GetMapping("/post/searchTitle/{title}")
	public ResponseEntity<?> searchPostByTitle(@PathVariable String title)
	{
		List<Post> searchPostByTitle = postService.searchPostByTitle(title);
		
		return ResponseEntity.status(HttpStatus.OK).body(searchPostByTitle);
	}
	
	
 }
