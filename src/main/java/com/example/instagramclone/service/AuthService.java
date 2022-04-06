package com.example.instagramclone.service;

import com.example.instagramclone.config.MailSender;
import com.example.instagramclone.entity.User;
import com.example.instagramclone.payload.ApiResponse;
import com.example.instagramclone.payload.RegisterDto;
import com.example.instagramclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    final MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);

        return byUsername.orElseThrow(() -> new UsernameNotFoundException("User topilmadi!"));
    }

    public ApiResponse register(RegisterDto dto) throws MessagingException {
        boolean byUsername = userRepository.existsByUsername(dto.getUsername());
        if (byUsername) {
            return new ApiResponse("This username is already exist", false);
        }
        boolean byPhone = userRepository.existsByPhone(dto.getPhone());
        if (byPhone) {
            return new ApiResponse("This phone number is already exist", false);
        }
        boolean byEmail = userRepository.existsByEmail(dto.getEmail());
        if (byEmail) {
            return new ApiResponse("This email is already exist", false);
        }
        User user = new User();
        if (dto.getEmail().contains("@")) {
            user.setEmail(dto.getEmail());
        } else {
            user.setPhone(dto.getPhone());
        }
        user.setUsername(dto.getUsername());
        user.setFullName(dto.getFullName());
        user.setPassword(dto.getPassword());
        user.setActive(true);

        //4 xonali
        String code = UUID.randomUUID().toString().substring(0, 5).concat(UUID.randomUUID().toString().substring(0, 5));

        SimpleMailMessage message = new SimpleMailMessage();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.addHeader("content-type", "html/text");
        message.setFrom("pdp@gmail.com");
        message.setTo(dto.getEmail());
        message.setSubject("Tasdiqlash kodi");
        message.setText("<a href='localhost/api/auth/verifyEmail?email=" + dto.getEmail() + "&code=" + code + "'>Tasdiqlash  kodi</a>");
        message.setSentDate(new Date());
        mailSender.getEmail().send(message);
        userRepository.save(user);
        return new ApiResponse("Mailga xabar ketti Tasdiqlang!", true);
    }
    public String verify(String email, String code,String password) {
        Optional<User> byUserName = userRepository.findByEmail(email);
        if (!byUserName.isPresent()) return "Xatolik!";

        if (!byUserName.get().getPassword().equals(passwordEncoder.encode(password))) return "Notogri";

        return "Yaxshi";

    }
}
