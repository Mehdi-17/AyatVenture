package com.ayatventure.ayatventure.controller;

import com.ayatventure.ayatventure.DTO.GameDTO;
import com.ayatventure.ayatventure.service.GameService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@AllArgsConstructor
@RequestMapping("games")
public class GameController {

    private GameService gameService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createGame(@RequestBody GameDTO gameDTO) {
        try {
            GameDTO gameCreatedDTO = gameService.createGame(gameDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(gameCreatedDTO);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGame(@PathVariable("id") Long gameId) {
        try {
            GameDTO gameDTO = gameService.getGame(gameId);

            return ResponseEntity.status(HttpStatus.OK).body(gameDTO);

        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGame(@PathVariable("id") Long gameId, @RequestBody GameDTO gameToUpdate) {
        try {
            GameDTO gameUpdated = gameService.updateGame(gameId, gameToUpdate);

            return ResponseEntity.status(HttpStatus.OK).body(gameUpdated);

        } catch (ResponseStatusException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
