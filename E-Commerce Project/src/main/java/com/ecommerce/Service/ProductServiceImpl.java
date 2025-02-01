package com.ecommerce.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.Entities.Category;
import com.ecommerce.Entities.Product;
import com.ecommerce.Exception.APIException;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Pagination.ProductResponse;
import com.ecommerce.Payload.ProductDTO;
import com.ecommerce.Repository.CategoryRepo;
import com.ecommerce.Repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductServiceI
{
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Value("${project.image}")
	private String path;
	
	public ProductDTO addProduct(ProductDTO productDto, int categoryId)
	{
		Product product = dtoToProduct(productDto);
		
		Category category = categoryRepo.findById(categoryId)
					.orElseThrow(()->new ResourceNotFoundException("Category with given Id not found"));
		
		
		boolean isProductNotPresent=true;
		
		List<Product> products = category.getProducts();
		for(Product eachProduct:products)
		{
			if(eachProduct.getProductName().equals(productDto.getProductName()))
			{
				isProductNotPresent=false;
				break;
			}
		}
		
		if(isProductNotPresent)
		{
		
			product.setImage("default.png");
		
			product.setCategory(category);
		
			double specialPrice=productDto.getPrice()-((productDto.getDiscount()*0.01)*productDto.getPrice());
		
			product.setSpecialPrice(specialPrice);
		
			Product saveProduct = productRepo.save(product);
		
			ProductDTO productDTO = productToDto(saveProduct);
			
			return productDTO;	
		}
		else
		{
			throw new APIException("Product already exist in the category.");
		}
	}
	
	public ProductResponse getAllProducts(int pageNumber, int pageSize, String sortBy) 
	{
		Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
		
		Page<Product> allPages = productRepo.findAll(page);
		
		List<Product> productList = allPages.getContent();
		
		if(productList.isEmpty())
		{
			throw new APIException("No Product Found.");
		}
		
		List<ProductDTO> collect = productList.stream().map(product->productToDto(product)).collect(Collectors.toList());
		
		ProductResponse response=new ProductResponse();
		
		response.setProduct(collect);
		response.setPageNumber(allPages.getNumber());
		response.setPageSize(allPages.getSize());
		response.setTotalPages(allPages.getTotalPages());
		response.setTotalPosts(allPages.getTotalElements());
		response.setLastPage(allPages.isLast());
		
		return response;
	}
	
	
	public ProductResponse getProductByCategory(int categoryId,int pageNumber,int pageSize,String sortBy) 
	{
		Category category = categoryRepo.findById(categoryId)
					.orElseThrow(()->new ResourceNotFoundException("Category Not found."));
		
		Pageable pageable=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
		
		Page<Product> findByCategory = productRepo.findByCategory(category,pageable);
		
		List<Product> content = findByCategory.getContent();
		
		if(content.isEmpty())
		{
			throw new APIException("No Products found in this Category.");
		}
		
		List<ProductDTO> collect = content.stream().map(product->productToDto(product)).collect(Collectors.toList());
		
		ProductResponse response=new ProductResponse();
		
		response.setProduct(collect);
		response.setPageNumber(findByCategory.getNumber());
		response.setPageSize(findByCategory.getSize());
		response.setTotalPages(findByCategory.getTotalPages());
		response.setTotalPosts(findByCategory.getTotalElements());
		response.setLastPage(findByCategory.isLast());
		
		return response;
	}
	
	
	public ProductResponse getProductByKeyword(String keyword, int pageNumber, int pageSize, String sortBy) 
	{
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		Page<Product> findByProductName = productRepo.findByProductNameLike('%'+keyword+'%', pageable);
		
		List<Product> content = findByProductName.getContent();
		
		if(content.isEmpty())
		{
			throw new APIException("No Product found matching the given keyword");
		}
		
		List<ProductDTO> collect = content.stream().map(product->productToDto(product)).collect(Collectors.toList());
		
		ProductResponse response=new ProductResponse();
		
		response.setProduct(collect);
		response.setPageNumber(findByProductName.getNumber());
		response.setPageSize(findByProductName.getSize());
		response.setTotalPages(findByProductName.getTotalPages());
		response.setTotalPosts(findByProductName.getTotalElements());
		response.setLastPage(findByProductName.isLast());
		
		return response;
	}
	
	public ProductDTO updateProduct(ProductDTO product, int productId) 
	{
		Product existingProduct = productRepo.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Product does not exist with given id"));
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setDiscount(product.getDiscount());
		
		double specialPrice=product.getPrice()-((product.getDiscount()*0.01)*product.getPrice());
		
		existingProduct.setSpecialPrice(specialPrice);
		
		Product updatedProduct = productRepo.save(existingProduct);
		
		ProductDTO productDto = productToDto(updatedProduct);
		
		return productDto;
	}

	public void deleteProduct(int productId) 
	{
		productRepo.findById(productId)
				.orElseThrow(()->new ResourceNotFoundException("Product does not exist with given Id."));
		
		productRepo.deleteById(productId);
	}
	
	public ProductDTO updateProductImage(int productId, MultipartFile file) throws IOException 
	{
		Product productFromDB = productRepo.findById(productId).
			orElseThrow(()->new ResourceNotFoundException("Product does not exist with given Id."));
		
		String fileName=upoadImage(path,file);
		
		productFromDB.setImage(fileName);
		
		Product updatedProduct = productRepo.save(productFromDB);
		
		ProductDTO productDTO = productToDto(updatedProduct);
		
		return productDTO;
	}
	
	private String upoadImage(String path, MultipartFile file) throws IOException 
	{
		//original file name
		String originalFilename = file.getOriginalFilename();
		//generate unique file name
		String randomId = UUID.randomUUID().toString();
		
		String randomFileName = randomId.concat(originalFilename.substring(originalFilename.lastIndexOf('.')));
		
		String filePath=path+File.separator+randomFileName;
		
		//check if file path exist
		File folder=new File(path);
		
		if(!folder.exists())
		{
			folder.mkdirs();
		}
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return randomFileName;
	}

	public Product dtoToProduct(ProductDTO productDto)
	{
		Product product = modelMapper.map(productDto, Product.class);
		return product;
	}
	
	public ProductDTO productToDto(Product product)
	{
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		return productDTO;
	}

	

	

	

	
	
	
}
