package com.third.blog.app.service;

import java.util.List;

import com.third.blog.app.payloads.PostDTO;
import com.third.blog.app.payloads.UserDTO;

public interface PostService {

	PostDTO createPost(PostDTO postDTO,Integer userId, Integer categoryId);
	PostDTO updatePost(PostDTO postDTO, Integer postId);
	PostDTO getPostById(Integer postId);
	List<PostDTO> getAllPosts();
	void deletePostById(Integer postId);
	
	List<PostDTO> getPostByCategory(Integer categoryId);
	List<PostDTO> getPostByUser(Integer userId);

}
