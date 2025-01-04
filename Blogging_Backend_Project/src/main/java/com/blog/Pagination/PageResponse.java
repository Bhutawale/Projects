package com.blog.Pagination;

import java.util.List;

import com.blog.entities.Post;

import lombok.Data;

@Data
public class PageResponse 
{
	private List<Post> post;
	private int pageNumber;
	private int pageSize;
	private int totalPosts;
	private int totalPages;
	private boolean lastPage;
}
