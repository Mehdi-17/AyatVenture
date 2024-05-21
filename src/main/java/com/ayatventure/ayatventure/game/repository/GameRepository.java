package com.ayatventure.ayatventure.game.repository;

import com.ayatventure.ayatventure.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
