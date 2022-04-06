package com.example.instagramclone.repository;

import com.example.instagramclone.entity.Followers;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface FollowersRepository extends JpaRepository<Followers, Integer> {

    List<Followers> findAllByUser_FullNameContainingIgnoreCase(String name);



}
