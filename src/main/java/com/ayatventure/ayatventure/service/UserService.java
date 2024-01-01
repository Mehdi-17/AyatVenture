package com.ayatventure.ayatventure.service;

import com.ayatventure.ayatventure.DTO.UserDTO;
import com.ayatventure.ayatventure.model.User;
import com.ayatventure.ayatventure.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void createUser(UserDTO userDTO){
        User userToCreate = User.builder()
                .username(userDTO.username())
                .password(userDTO.password())
                .email(userDTO.email())
                .gamesPlayed(userDTO.gamesPlayed())
                .personalRecord(userDTO.personalRecord())
                .build();

        userRepository.save(userToCreate);
    }
}
