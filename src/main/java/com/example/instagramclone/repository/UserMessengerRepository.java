package com.example.instagramclone.repository;

import com.example.instagramclone.entity.UserMessenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMessengerRepository extends JpaRepository<UserMessenger,Integer> {

}
