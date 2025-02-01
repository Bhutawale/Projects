package com.ecommerce.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Entities.Category;
import com.ecommerce.Entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{
	Page<Product> findByCategory(Category category,Pageable pageable);
	
	Page<Product> findByProductNameLike(String keyword,Pageable pageable);
}
