package com.third.blog.app.service;

import java.util.List;

import com.third.blog.app.payloads.CategoryDTO;
import com.third.blog.app.payloads.UserDTO;


public interface CategoryService {
	CategoryDTO createCategory(CategoryDTO categoryDTO);
	CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
	CategoryDTO getCategoryById(Integer categoryId);
	List<CategoryDTO> getAllCategories();
	void deleteCategoryById(Integer categoryId);

}
