package com.ayatventure.ayatventure.user.controller;

import com.ayatventure.ayatventure.user.DTO.UserDTO;
import com.ayatventure.ayatventure.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        String usernameCreated = userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(usernameCreated);
    }
}
