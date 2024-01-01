package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.mapper.GameMapper;
import com.ayatventure.ayatventure.model.Game;
import com.ayatventure.ayatventure.service.GameService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("games")
public class GameController {

    private GameService gameService;

    @PostMapping
    @Transactional
    public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO gameDTO) {
        Game createdGame = gameService.createGame(gameDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(GameMapper.INSTANCE.gametoGameDto(createdGame));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable("id") Long gameId) {
        return ResponseEntity.ok().body(gameService.getGame(gameId));
    }

    //TODO: create the update of a Game
}
