package com.third.blog.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.third.blog.app.entity.Category;
import com.third.blog.app.entity.Post;
import com.third.blog.app.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Category> findByCategory(Category category);
    
}
