package com.ayatventure.ayatventure.repository;

import com.ayatventure.ayatventure.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
