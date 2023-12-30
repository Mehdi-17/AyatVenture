package com.ayatventure.ayatventure.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Date beginDate;

    @Column(name = "score")
    private Long score;

    @Column(name = "total_question")
    private Long totalQuestion;

    @Column(name = "current_question_count")
    private Long currentQuestionCount;
}
