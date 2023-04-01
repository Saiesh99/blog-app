package com.third.blog.app.service;

import java.util.List;

import com.third.blog.app.payloads.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
	UserDTO updateUser(UserDTO userDTO, Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUserById(Integer userId);

}
