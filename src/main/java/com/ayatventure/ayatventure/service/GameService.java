package com.ayatventure.ayatventure.service;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.DTO.JokerDTO;
import com.ayatventure.ayatventure.mapper.GameMapper;
import com.ayatventure.ayatventure.model.Game;
import com.ayatventure.ayatventure.model.Joker;
import com.ayatventure.ayatventure.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class GameService {

    private GameRepository gameRepository;
    private UserService userService;

    public GameDTO createGame(GameDTO gameDTO) {
        Game gameToCreate = Game.builder()
                .user(userService.getByUsername(gameDTO.username()))
                //todo: check if i used the date send by the front
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

        Predicate<Joker> keepUnusedJoker = joker -> gameUpdated.jokers()
                .stream().map(JokerDTO::name)
                .anyMatch(jokerName -> jokerName.equals(joker.getName()));

        game.setScore(gameUpdated.score());
        game.setJokers(game.getJokers().stream().filter(keepUnusedJoker).toList());
        game.setCurrentQuestionCount(game.getCurrentQuestionCount() + 1);

        return GameMapper.INSTANCE.gametoGameDto(gameRepository.save(game));
    }
}
