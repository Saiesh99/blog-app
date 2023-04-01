package com.third.blog.app.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.third.blog.app.payloads.ApiResponse;
import com.third.blog.app.payloads.CategoryDTO;
import com.third.blog.app.payloads.UserDTO;
import com.third.blog.app.service.CategoryService;
import com.third.blog.app.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
		CategoryDTO createdCategoryDTO = categoryService.createCategory(categoryDTO);
		return new ResponseEntity<>(createdCategoryDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,@PathVariable("categoryId") Integer categoryId){
		CategoryDTO updatedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
		return new ResponseEntity<>(updatedCategoryDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		this.categoryService.deleteCategoryById(categoryId);
		//return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);
		return new ResponseEntity<>(new ApiResponse("category deletd successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategories(){
		//this.userService.getAllUsers();
		return new ResponseEntity<>(this.categoryService.getAllCategories(),HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("categoryId") Integer categoryId){
		//this.userService.getAllUsers();
		return new ResponseEntity<>(this.categoryService.getCategoryById(categoryId),HttpStatus.OK);
	}	
	
}
