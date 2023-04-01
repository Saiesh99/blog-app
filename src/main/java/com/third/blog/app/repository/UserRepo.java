package com.third.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.third.blog.app.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
