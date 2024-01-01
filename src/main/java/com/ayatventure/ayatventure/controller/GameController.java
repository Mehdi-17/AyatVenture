package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.model.Game;
import com.ayatventure.ayatventure.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@AllArgsConstructor
@RequestMapping("games")
public class GameController {

    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> createGame(GameDTO gameDTO) {
        Game createdGame = gameService.createGame(gameDTO);

        String gameLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdGame.getId())
                .toUriString();

        return ResponseEntity.created(java.net.URI.create(gameLocation)).body(createdGame);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable("id") Long gameId) {
        return ResponseEntity.ok().body(gameService.getGame(gameId));
    }

    //TODO: create the update of a Game
}
