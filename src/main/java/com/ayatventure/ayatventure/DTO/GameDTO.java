package com.ayatventure.ayatventure.DTO;

import com.ayatventure.ayatventure.model.User;


public record GameDTO(User user, int score, int totalQuestion, int currentQuestionCount) {
}
