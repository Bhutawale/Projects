package com.blog.services;

import java.util.List;

import com.blog.Pagination.PageResponse;
import com.blog.entities.Post;

public interface PostServiceI 
{
	public Post createPost(Post post,int userId,int catId);
	
	public Post findPostById(int id);
	
	public PageResponse findAllPosts(int pageNo,int pageSize,String sortBy);
	
	public void deletePost(int id);
	
	public Post updatePost(Post post,int id);
	
	public List<Post> findPostByCategory(int catId);

	public List<Post> findPostByUser(int userId);
	
	public List<Post> searchPostByTitle(String title);
}
 