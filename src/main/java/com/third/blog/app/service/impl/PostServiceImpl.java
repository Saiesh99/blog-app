package com.third.blog.app.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.third.blog.app.entity.Category;
import com.third.blog.app.entity.Post;
import com.third.blog.app.entity.User;
import com.third.blog.app.exception.ResourceNotFoundException;
import com.third.blog.app.payloads.PostDTO;
import com.third.blog.app.repository.CategoryRepo;
import com.third.blog.app.repository.PostRepo;
import com.third.blog.app.repository.UserRepo;
import com.third.blog.app.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));
		Category category= categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
		
		Post post = modelMapper.map(postDTO, Post.class);
		post.setAddedDate(new Date());
		post.setImageName("default.png");
		post.setUser(user);
		post.setCategory(category);
		
		Post savedPost = postRepo.save(post);
		return modelMapper.map(savedPost, PostDTO.class);
	}

	@Override
	public PostDTO updatePost(PostDTO postDTO, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePostById(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDTO> getPostByCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
		
	//	List<Post> postList = postRepo.findByCategory(category); 
		return null;
	}

	@Override
	public List<PostDTO> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
 
}
