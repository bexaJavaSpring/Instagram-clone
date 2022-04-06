package com.example.instagramclone.repository;

import com.example.instagramclone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByUser_Id(Integer id);
}
