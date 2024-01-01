package com.ayatventure.ayatventure.service;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.model.Game;
import com.ayatventure.ayatventure.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;
    private UserService userService;

    public Game createGame(GameDTO gameDTO) {
        Game gameToCreate = Game.builder()
                .user(userService.getByUsername(gameDTO.username()))
                .beginDate(LocalDate.now())
                .score(0)
                .totalQuestion(gameDTO.totalQuestion())
                .currentQuestionCount(0)
                .build();

        //todo: dont forget to create associated Jokers

        return gameRepository.save(gameToCreate);
    }

    public Game getGame(Long gameId) {
        Optional<Game> gameOpt = gameRepository.findById(gameId);

        return gameOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found."));
    }
}
