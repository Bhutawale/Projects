package com.ecommerce.Pagination;

import java.util.List;

import com.ecommerce.Payload.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse 
{
	private List<CategoryDTO> category;
	private int pageNumber;
	private int pageSize;
	private long totalPosts;
	private int totalPages;
	private boolean lastPage;
}
