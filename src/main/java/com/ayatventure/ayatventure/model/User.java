package com.ayatventure.ayatventure.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_table")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "games_played")
    private Long gamesPlayed;

    @Column(name = "personal_record")
    private Long personalRecord;

}
