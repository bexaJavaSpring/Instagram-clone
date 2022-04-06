package com.example.instagramclone.service;

import com.example.instagramclone.repository.UserMessengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessengerService {

    @Autowired
    UserMessengerRepository userMessengerRepository;
}
