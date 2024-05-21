package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.DTO.UserDTO;
import com.ayatventure.ayatventure.service.UserService;
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

    //todo: implement joker feature with Strategy design pattern

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        String usernameCreated = userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(usernameCreated);
    }
}
