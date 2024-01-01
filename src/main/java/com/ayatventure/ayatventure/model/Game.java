package com.ayatventure.ayatventure.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "games")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "begin_date", nullable = false)
    private LocalDate beginDate;

    @Column(name = "score")
    private int score;

    @Column(name = "total_question")
    private int totalQuestion;

    @Column(name = "current_question_count")
    private int currentQuestionCount;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Joker> jokers;
}
