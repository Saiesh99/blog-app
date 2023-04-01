package com.third.blog.app.controller;

import java.util.List;
import java.util.Map;

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
import com.third.blog.app.payloads.UserDTO;
import com.third.blog.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
		UserDTO createdUserDTO = userService.createUser(userDTO);
		return new ResponseEntity<>(createdUserDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable("userId") Integer userId){
		UserDTO updatedUserDTO = userService.updateUser(userDTO, userId);
		return new ResponseEntity<>(updatedUserDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
		this.userService.deleteUserById(userId);
		//return new ResponseEntity<>(Map.of("message","user deleted successfully"),HttpStatus.OK);
		return new ResponseEntity<>(new ApiResponse("user deletd successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		//this.userService.getAllUsers();
		return new ResponseEntity<>(this.userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Integer userId){
		//this.userService.getAllUsers();
		return new ResponseEntity<>(this.userService.getUserById(userId),HttpStatus.OK);
	}	
	
	
}
