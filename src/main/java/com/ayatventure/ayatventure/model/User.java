package com.ayatventure.ayatventure.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
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

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "games_played", nullable = false)
    private int gamesPlayed;

    @Column(name = "personal_record")
    private int personalRecord;

}
