package com.blog.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.Pagination.PageResponse;
import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repositories.CategoryDao;
import com.blog.repositories.PostDao;
import com.blog.repositories.UserDao;

@Service
public class PostServiceImpl implements PostServiceI 
{
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public Post createPost(Post post,int userId,int catId) 
	{
		
		User userById = userDao.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User does not exist."));
		
		Category categoryById = categoryDao.findById(catId)
				.orElseThrow(()->new ResourceNotFoundException("Category does not exist."));
		
		post.setUser(userById);
		post.setCategory(categoryById);
		
		post.setAddedDate(new Date());
			
		post.setImageName("default.png");
		
		Post savePost = postDao.save(post);
		
		return savePost;
	}

	public Post findPostById(int id) 
	{
		Post postById = postDao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Post with given Id "+id+" not found."));
		return postById;
	}

	public PageResponse findAllPosts(int pageNo,int pageSize,String sortBy) 
	{
		
		Pageable page=PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		
		Page<Post> pagePost = postDao.findAll(page);
		
		List<Post> allPosts = pagePost.getContent();
		
		PageResponse pageResponse=new PageResponse();
		
		pageResponse.setPost(allPosts);
		pageResponse.setPageNumber(pagePost.getNumber());
		pageResponse.setPageSize(pagePost.getSize());
		pageResponse.setTotalPages(pagePost.getTotalPages());
		pageResponse.setTotalPosts(allPosts.size());
		pageResponse.setLastPage(pagePost.isLast());
		
		
		return pageResponse;
	}

	public void deletePost(int id) 
	{
		postDao.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Post with given Id "+id+" not found."));
		
		postDao.deleteById(id);
	}

	public Post updatePost(Post post, int id) 
	{
		Post postById = postDao.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Post with given Id "+id+" not found."));
		
		postById.setTitle(post.getTitle());
		postById.setContent(post.getContent());
		postById.setAddedDate(new Date());
		postById.setImageName(post.getImageName());
		
		Post updatedPost = postDao.save(postById);
		
		return updatedPost;
	}

	public List<Post> findPostByCategory(int catId) 
	{
		Category categoryById = categoryDao.findById(catId)
				.orElseThrow(()->new ResourceNotFoundException("Category with given Id does not exist."));
	
		List<Post> findPostByCategory = postDao.findPostByCategory(categoryById.getId());
		
		
		return findPostByCategory;
	}

	public List<Post> findPostByUser(int userId) 
	{
		User userById = userDao.findById(userId)
			.orElseThrow(()->new ResourceNotFoundException("User with given Id does not exist."));
		
		List<Post> findPostByUser = postDao.findPostByUser(userById.getId());
		
		return findPostByUser;
	}
	
	public List<Post> searchPostByTitle(String title)
	{
		List<Post> searchByTitleContaining = postDao.searchByTitleContaining(title);
		
		return searchByTitleContaining;
	}
}
