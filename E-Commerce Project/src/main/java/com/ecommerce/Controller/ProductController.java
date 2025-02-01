package com.ecommerce.Controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ApplicationConstants.AppConstants;
import com.ecommerce.Pagination.ProductResponse;
import com.ecommerce.Payload.ProductDTO;
import com.ecommerce.Service.ProductServiceI;

@RestController
@RequestMapping("/api")
public class ProductController 
{
	@Autowired
	private ProductServiceI productService;
	
	@PostMapping("/admin/categories/{categoryId}/product")
	public ResponseEntity<?> addProduct(@Valid
					@RequestBody ProductDTO product,
					@PathVariable int categoryId) 
	{
		
		ProductDTO addProduct = productService.addProduct(product,categoryId);
		return ResponseEntity.status(HttpStatus.OK).body(addProduct);
		
	}
	
	@GetMapping("/public/findAllProducts")
	public ResponseEntity<?> getAllProducts(
			@RequestParam(name ="pageNumber",defaultValue =AppConstants.PAGE_NUMBER)int pageNumber,
			@RequestParam(name ="pageSize",defaultValue = AppConstants.PAGE_SIZE) int pageSize,
			@RequestParam(name = "sortBy",defaultValue = AppConstants.SORTBYPRODUCTNAME) String sortBy
			)
	{
		ProductResponse allProducts = productService.getAllProducts(pageNumber, pageSize, sortBy);
		return ResponseEntity.status(HttpStatus.OK).body(allProducts);
	}
	
	@GetMapping("/public/categories/{categoryId}/findProducts")
	public ResponseEntity<?> findProductByCategory(@PathVariable int categoryId,
			@RequestParam(name ="pageNumber",defaultValue =AppConstants.PAGE_NUMBER)int pageNumber,
			@RequestParam(name ="pageSize",defaultValue = AppConstants.PAGE_SIZE) int pageSize,
			@RequestParam(name = "sortBy",defaultValue = AppConstants.SORTBYPRODUCTNAME) String sortBy)
	{
		ProductResponse productByCategory = productService.getProductByCategory(categoryId,pageNumber,pageSize,sortBy);
		return ResponseEntity.status(HttpStatus.OK).body(productByCategory);
	}
	
	@GetMapping("/public/products/keyword/{keyword}")
	public ResponseEntity<?> findProductByKeyword(@PathVariable String keyword,
			@RequestParam(name ="pageNumber",defaultValue =AppConstants.PAGE_NUMBER)int pageNumber,
			@RequestParam(name ="pageSize",defaultValue = AppConstants.PAGE_SIZE) int pageSize,
			@RequestParam(name = "sortBy",defaultValue = AppConstants.SORTBYPRODUCTNAME) String sortBy)
	{
		ProductResponse productByKeyword = productService.getProductByKeyword(keyword, pageNumber, pageSize, sortBy);
		return ResponseEntity.status(HttpStatus.OK).body(productByKeyword);
	}
	
	@PutMapping("/admin/product/updateProduct/{productId}")
	public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDTO productDto,@PathVariable int productId)
	{
		ProductDTO updatedProduct = productService.updateProduct(productDto, productId);
		return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}
	
	@DeleteMapping("/admin/product/deleteProduct/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable int productId)
	{
		productService.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body("Product Deleted Successfully");
	}
	
	@PutMapping("/admin/products/{productId}/image")
	public ResponseEntity<?> updateProductImage(@PathVariable int productId,
			@RequestParam("image") MultipartFile file) throws IOException
	{
			ProductDTO	updatedProduct=productService.updateProductImage(productId,file);
			return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}
}
