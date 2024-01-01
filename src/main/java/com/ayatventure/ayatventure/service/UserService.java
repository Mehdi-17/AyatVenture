package com.ayatventure.ayatventure.service;

import com.ayatventure.ayatventure.DTO.UserDTO;
import com.ayatventure.ayatventure.model.User;
import com.ayatventure.ayatventure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public String createUser(UserDTO userDTO) {
        User userToCreate = User.builder()
                .username(userDTO.username())
                .password(userDTO.password())
                .email(userDTO.email())
                .gamesPlayed(0)
                .personalRecord(0)
                .build();

        User userCreated = userRepository.save(userToCreate);

        return userCreated.getUsername();
    }

    public User getByUsername(String username) {
        return userRepository.getUserByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with username : " + username));
    }
}
