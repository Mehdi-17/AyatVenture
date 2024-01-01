package com.ayatventure.ayatventure.DTO;

import com.ayatventure.ayatventure.model.Joker;

import java.time.LocalDate;
import java.util.List;

public record GameDTO(Long id, String username, LocalDate beginDate, int score, int totalQuestion, int currentQuestionCount, List<Joker> jokers) {
}
