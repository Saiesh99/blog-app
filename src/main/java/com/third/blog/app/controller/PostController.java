package com.third.blog.app.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.third.blog.app.payloads.PostDTO;
import com.third.blog.app.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/users/{userId}/categories/{categoryId}")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable("userId") Integer userId, @PathVariable("categoryId") Integer categoryId){
		
		PostDTO createdUser = postService.createPost(postDTO, userId, categoryId);
		return new ResponseEntity<>(createdUser,HttpStatus.ACCEPTED);
	}
}
