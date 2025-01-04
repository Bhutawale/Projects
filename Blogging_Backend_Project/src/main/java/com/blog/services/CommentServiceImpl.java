package com.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Comments;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repositories.CommentsDao;
import com.blog.repositories.PostDao;
import com.blog.repositories.UserDao;

@Service
public class CommentServiceImpl implements CommentServiceI 
{
	@Autowired
	private CommentsDao commentDao;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private UserDao userDao;

	
	public Comments createComment(Comments comment, int postId,int userId) 
	{
		Post postById = postDao.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post with given Id does not exist."));
		
		User userById = userDao.findById(userId)
			.orElseThrow(()->new ResourceNotFoundException("User does not exist"));
		
		comment.setPost(postById);
		
		comment.setUser(userById);
		
		Comments saveComment = commentDao.save(comment);
		
		return saveComment;
	}

	public void deleteComment(int id) 
	{
		commentDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Comment does not exist."));
		
		commentDao.deleteById(id);
	}

}
