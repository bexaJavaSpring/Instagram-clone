package com.example.instagramclone.repository;

import com.example.instagramclone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer> {
}
