package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.model.Game;
import com.ayatventure.ayatventure.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("games")
public class GameController {

    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> createGame(GameDTO gameDTO) {
        Game createdGame = gameService.createGame(gameDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable("id") Long gameId) {
        return ResponseEntity.ok().body(gameService.getGame(gameId));
    }

    //TODO: create the update of a Game
}
