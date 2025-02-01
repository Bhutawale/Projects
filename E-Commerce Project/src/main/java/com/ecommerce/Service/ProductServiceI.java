package com.ecommerce.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.Pagination.ProductResponse;
import com.ecommerce.Payload.ProductDTO;

public interface ProductServiceI 
{

	ProductDTO addProduct(ProductDTO product, int categoryId);
	
	ProductResponse getAllProducts(int pageNumber,int pageSize,String sortBy);
	
	ProductResponse getProductByCategory(int categoryId,int pageNumber,int pageSize,String sortBy);
	
	ProductResponse getProductByKeyword(String keyword,int pageNumber,int pageSize,String sortBy);
	
	ProductDTO updateProduct(ProductDTO product,int productId);
	
	void deleteProduct(int productId);

	ProductDTO updateProductImage(int productId, MultipartFile file) throws IOException;
}
