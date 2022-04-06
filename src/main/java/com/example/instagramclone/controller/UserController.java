package com.example.instagramclone.controller;

import com.example.instagramclone.entity.User;
import com.example.instagramclone.payload.LoginDto;
import com.example.instagramclone.payload.RegisterDto;
import com.example.instagramclone.security.JwtProvider;
import com.example.instagramclone.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    final AuthenticationManager authenticationManager;
    final AuthService authService;
    final JwtProvider jwtProvider;

    @PostMapping("login")
    public HttpEntity<?> login(@RequestBody LoginDto dto){
        String token = jwtProvider.generateToken(dto.getUsername());
        return ResponseEntity.ok().body(token);
    }
    @GetMapping("/me")
    public HttpEntity<?> getMe(User user) { //Parametr
        return ResponseEntity.ok().body("Mana" + user);
    }


    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto dto) throws MessagingException {
        return ResponseEntity.ok().body(authService.register(dto));
    }

    @GetMapping("/verifyEmail")
    public HttpEntity<?> verify(@RequestParam String email, @RequestParam String code, @RequestBody String password) {

        String verify = authService.verify(email,code, password);
        return ResponseEntity.ok().body(verify);
    }



}
