package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.Comments;
import com.blog.services.CommentServiceI;

@RestController
@RequestMapping("/api")
public class CommentController 
{
	
	@Autowired
	private CommentServiceI commentService;
	
	@PostMapping("/user/{userId}/post/{postId}/saveComment")
	public ResponseEntity<?> saveComment(@RequestBody Comments comment,
										@PathVariable int postId,
										@PathVariable int userId)
	{
		Comments createComment = commentService.createComment(comment, postId,userId);
		return ResponseEntity.status(HttpStatus.OK).body(createComment);
	}
	
	@DeleteMapping("/deleteComment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable int id)
	{
		commentService.deleteComment(id);
		return ResponseEntity.status(HttpStatus.OK).body("Comment Deleted Successfully.");
	}
}
