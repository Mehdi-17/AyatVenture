package com.ayatventure.ayatventure.game.DTO;

import com.ayatventure.ayatventure.joker.DTO.JokerDTO;

import java.time.LocalDate;
import java.util.List;

public record GameDTO(Long id, String username, LocalDate beginDate, int score, int totalQuestion, int currentQuestionCount, List<JokerDTO> jokers) {
}
