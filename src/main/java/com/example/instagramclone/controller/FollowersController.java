package com.example.instagramclone.controller;

import com.example.instagramclone.entity.User;
import com.example.instagramclone.payload.FollowersDto;
import com.example.instagramclone.repository.FollowersRepository;
import com.example.instagramclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/followers")
@RequiredArgsConstructor
public class FollowersController {

    final FollowersRepository followersRepository;
    final UserRepository userRepository;

    @GetMapping
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(followersRepository.findAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(followersRepository.findById(id).get());
    }
    @GetMapping("/search")
    public HttpEntity<?> search(@RequestBody FollowersDto dto){
        Optional<User> byId = userRepository.findById(dto.getUserId());
        User user = byId.get();
        return ResponseEntity.ok().body(followersRepository.findAllByUser_FullNameContainingIgnoreCase(user.getFullName()));
    }
}
