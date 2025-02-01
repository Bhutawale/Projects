package com.ecommerce.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.Entities.Category;
import com.ecommerce.Exception.APIException;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Pagination.CategoryResponse;
import com.ecommerce.Payload.CategoryDTO;
import com.ecommerce.Repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryServiceI
{

	@Autowired
	private CategoryRepo categoryDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) 
	{
		Category category = dtoToCategory(categoryDto);
		
		Category byCategoryName = categoryDao.findByCategoryName(category.getCategoryName());
		if(byCategoryName!=null)
		{
			throw new APIException("Category with the name "+category.getCategoryName() +" Already Exist.");
		}
		Category saveCategory = categoryDao.save(category);
		
		CategoryDTO createCategory = categoryToDto(saveCategory);
		
		return createCategory;
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId)
	{
		Category category = categoryDao.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Resource Not Found."));
		
		CategoryDTO categoryById = categoryToDto(category);
		
		return categoryById;
	}

	@Override
	public CategoryResponse getAllCategories(int pageNumber,int pageSize,String sortBy) 
	{
		Pageable pageDetails= PageRequest.of(pageNumber,pageSize,Sort.by(sortBy).ascending());
		
		Page<Category> categoryPage = categoryDao.findAll(pageDetails);
		
		List<Category> allCategories = categoryPage.getContent();
		
		if(allCategories.isEmpty())
			throw new APIException("No Categories to show.");
		
		List<CategoryDTO> collect = allCategories.stream().map(Cat->this.categoryToDto(Cat)).collect(Collectors.toList());
		
		CategoryResponse response=new CategoryResponse();
		
		response.setCategory(collect);
		response.setPageNumber(categoryPage.getNumber());
		response.setPageSize(categoryPage.getSize());
		response.setTotalPages(categoryPage.getTotalPages());
		response.setTotalPosts(categoryPage.getTotalElements());
		response.setLastPage(categoryPage.isLast());
		
		return response;
	}

	@Override
	public void deleteCategory(int categoryId)
	{
		categoryDao.findById(categoryId)
		.orElseThrow(()->new ResponseStatusException
				(HttpStatus.NOT_FOUND,"Category with Given Id "+" does not exist."));
		
		categoryDao.deleteById(categoryId);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, int categoryId) 
	{
		Category categoryToUpdate = categoryDao.findById(categoryId)
				.orElseThrow(()->new ResponseStatusException
						(HttpStatus.NOT_FOUND,"Category with Given Id "+" does not exist."));
		
		categoryToUpdate.setCategoryName(categoryDto.getCategoryName());	
		
		Category updatedCategory = categoryDao.save(categoryToUpdate);
		
		CategoryDTO updatedCat = categoryToDto(updatedCategory);
		
		return updatedCat;
	}
	
	
	public Category dtoToCategory(CategoryDTO categoryDto)
	{
		Category category = modelMapper.map(categoryDto, Category.class);
		return category;
	}
	
	public CategoryDTO categoryToDto(Category category)
	{
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}
}
