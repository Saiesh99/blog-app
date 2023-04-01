package com.third.blog.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.third.blog.app.entity.Category;
import com.third.blog.app.entity.User;
import com.third.blog.app.exception.ResourceNotFoundException;
import com.third.blog.app.payloads.CategoryDTO;
import com.third.blog.app.repository.CategoryRepo;
import com.third.blog.app.repository.UserRepo;
import com.third.blog.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);
		Category savedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(savedCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
		// TODO Auto-generated method stub
		Category savedCategory = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		savedCategory.setCategoryDescription(categoryDTO.getCategoryDescription());
		savedCategory.setCategoryTitle(categoryDTO.getCategoryTitle());
		Category updatedCategory = this.categoryRepo.save(savedCategory);
		return modelMapper.map(updatedCategory,CategoryDTO.class);
	}

	@Override
	public CategoryDTO getCategoryById(Integer categoryId) {
		Category savedCategory = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		
		return  modelMapper.map(savedCategory,CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categoryList = this.categoryRepo.findAll();
		List<CategoryDTO> categoryDTOList = categoryList.stream().map(category->modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
		return categoryDTOList;
	}

	@Override
	public void deleteCategoryById(Integer categoryId) {
		Category savedCategory = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		this.categoryRepo.delete(savedCategory);
		
	}

}
