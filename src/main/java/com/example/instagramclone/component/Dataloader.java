package com.example.instagramclone.component;//package uz.pdp.component;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import uz.pdp.entity.Role;
//import uz.pdp.entity.User;
//import uz.pdp.entity.enums.PermissionEnum;
//import uz.pdp.entity.enums.RoleEnum;
//import uz.pdp.repository.RoleRepository;
//import uz.pdp.repository.UserRepository;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class Dataloader implements CommandLineRunner {
//
//    final UserRepository userRepository;
//    final PasswordEncoder passwordEncoder;
//    final RoleRepository roleRepository;
//    @Value("${spring.sql.init.mode}")
//    String mode;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (mode.equals("always")) {
//            PermissionEnum[] values = PermissionEnum.values();
//
//            List<Role> roleList = new ArrayList<>();
//            Role userRole = roleRepository.save(new Role(RoleEnum.USER, new ArrayList<>(Arrays.asList(
//                    PermissionEnum.READ_ALL_COMMENT,
//                    PermissionEnum.READ_ONE_COMMENT
//            ))));
//            Role adminRole = roleRepository.save(new Role(RoleEnum.ADMIN, Arrays.asList(values)));
//
//            roleList.add(userRole);
//            roleList.add(adminRole);
//            userRepository.save(new User("Bekhruz", passwordEncoder.encode("0000"), roleList));
//
//        }
//    }
//}
