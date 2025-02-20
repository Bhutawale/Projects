package com.productApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productApp.Dao.ProductDao;
import com.productApp.Model.Product;

@Service
public class ProductService 
{
	@Autowired
	private ProductDao productDao;
	
	public void saveProduct(Product product)
	{
		productDao.saveProduct(product);
	}
	
	public List<Product> getAllProduts()
	{
		List<Product> allProducts = productDao.getAllProducts();
		return allProducts;
	}
	
	public Product getProductById(int pid)
	{
		Product productById = productDao.getProductById(pid);
		return productById;
	}
	
	public void deleteProduct(int pid)
	{
		productDao.deleteProduct(pid);
	}
	
	public Product updateProduct(int pid,Product product)
	{
		Product updatedProduct = productDao.updateProduct(pid, product);
		return updatedProduct;
	}
}
