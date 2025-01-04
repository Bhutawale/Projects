package com.blog.services;

import com.blog.entities.Comments;

public interface CommentServiceI 
{
	public Comments createComment(Comments comment,int postId,int userId);
	
	public void deleteComment(int id);
	
}
