package com.example.instagramclone.service;

import com.example.instagramclone.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {

    @Autowired
    LikesRepository likesRepository;
}
