package com.example.instagramclone.repository;

import com.example.instagramclone.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikesRepository extends JpaRepository<Likes, Integer> {
}
