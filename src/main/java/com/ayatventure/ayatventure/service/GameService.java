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
                //todo: check if I used the date send by the front
                .beginDate(LocalDate.now())
                .score(0)
                .totalQuestion(gameDTO.totalQuestion())
                .currentQuestionCount(1)
                .build();

        //todo: dont forget to create associated Jokers

        return GameMapper.INSTANCE.gametoGameDto(gameRepository.save(gameToCreate));
    }

    public GameDTO getGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found."));

        return GameMapper.INSTANCE.gametoGameDto(game);
    }

    public GameDTO updateGame(Long gameId, GameDTO gameUpdated){
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found."));

       //todo manage when joker are used

        game.setScore(gameUpdated.score());
        game.setCurrentQuestionCount(game.getCurrentQuestionCount() + 1);

        return GameMapper.INSTANCE.gametoGameDto(gameRepository.save(game));
    }
}
