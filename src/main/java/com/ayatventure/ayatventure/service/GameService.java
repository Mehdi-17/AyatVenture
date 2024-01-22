package com.ayatventure.ayatventure.service;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.mapper.GameMapper;
import com.ayatventure.ayatventure.model.Game;
import com.ayatventure.ayatventure.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;
    private UserService userService;

    public GameDTO createGame(GameDTO gameDTO) {
        Game gameToCreate = Game.builder()
                .user(userService.getByUsername(gameDTO.username()))
                .beginDate(LocalDate.now())
                .score(0)
                .totalQuestion(gameDTO.totalQuestion())
                .currentQuestionCount(0)
                .build();

        //todo: dont forget to create associated Jokers

        return GameMapper.INSTANCE.gametoGameDto(gameRepository.save(gameToCreate));
    }

    public GameDTO getGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found."));

        return GameMapper.INSTANCE.gametoGameDto(game);
    }

    public GameDTO updateGame(GameDTO gameUpdated){
        Game game = gameRepository.findById(gameUpdated.id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found."));

        game.setScore(gameUpdated.score());
        game.setJokers(gameUpdated.jokers());
        game.setCurrentQuestionCount(game.getCurrentQuestionCount() + 1);

        return GameMapper.INSTANCE.gametoGameDto(gameRepository.save(game));
    }
}
