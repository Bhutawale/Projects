package com.ecommerce.Pagination;

import java.util.List;

import com.ecommerce.Payload.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse 
{
	private List<ProductDTO> product;
	private int pageNumber;
	private int pageSize;
	private long totalPosts;
	private int totalPages;
	private boolean lastPage;
}
