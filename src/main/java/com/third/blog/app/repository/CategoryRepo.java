package com.third.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.third.blog.app.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
