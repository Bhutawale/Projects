package com.productApp.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.productApp.Model.Product;

@Repository
public class ProductDao 
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveProduct(Product product)
	{
			hibernateTemplate.saveOrUpdate(product);
	}
	@Transactional
	public List<Product> getAllProducts()
	{
		List<Product> allProducts = hibernateTemplate.loadAll(Product.class);
		return allProducts;
	}
	
	@Transactional
	public Product getProductById(int pid)
	{
		Product productById = hibernateTemplate.get(Product.class, pid);
		return productById;
	}
	
	@Transactional
	public void deleteProduct(int pid)
	{
		Product productById = hibernateTemplate.load(Product.class, pid);
		if(productById!=null)
		{
			hibernateTemplate.delete(productById);
		}
		else
		{
			System.out.println("Product with given Id does not exist");
		}
	}
	
	@Transactional
	public Product updateProduct(int pid,Product product)
	{
		Product productToUpdate = hibernateTemplate.get(Product.class, pid);
		if(productToUpdate!=null) 
		{	
			productToUpdate.setName(product.getName());
			productToUpdate.setDescription(product.getDescription());
			productToUpdate.setPrice(product.getPrice());
			hibernateTemplate.update(productToUpdate);
			return productToUpdate;
		}
		else 
			return null;
	}
}
