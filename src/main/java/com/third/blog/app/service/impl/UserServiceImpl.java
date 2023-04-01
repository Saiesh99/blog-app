package com.third.blog.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.third.blog.app.entity.User;
import com.third.blog.app.payloads.UserDTO;
import com.third.blog.app.repository.UserRepo;
import com.third.blog.app.service.UserService;
import com.third.blog.app.exception.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.dtoToUser(userDTO);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	/**
	 *
	 */
	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setAbout(userDTO.getAbout());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		User updatedUser = this.userRepo.save(user);
		return this.userToDto(updatedUser);

	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		// System.out.println(users);

		List<UserDTO> userDTOList = users.stream().map(a -> userToDto(a)).collect(Collectors.toList());
		// System.out.println(userDTOs);
		return userDTOList;
	}

	@Override
	public void deleteUserById(Integer userId) {
		// TODO Auto-generated method stub

		this.userRepo.deleteById(userId);
	}

	public User dtoToUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
//		user.setAbout(userDTO.getAbout());
//		user.setEmail(userDTO.getEmail());
//		user.setId(userDTO.getId());
//		user.setName(userDTO.getName());
//		user.setPassword(userDTO.getPassword());
		return user;

	}

	public UserDTO userToDto(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//		userDTO.setAbout(user.getAbout());
//		userDTO.setEmail(user.getEmail());
//		userDTO.setId(user.getId());
//		userDTO.setName(user.getName());
//		userDTO.setPassword(user.getPassword());
		return userDTO;

	}

}
