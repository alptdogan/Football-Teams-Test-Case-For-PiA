package com.alpdogan.FootballTeamsTestCaseForPiA.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "is_foreigner")
    private boolean isForeigner;

    @Column(name = "is_goalkeeper")
    private boolean isGoalkeeper;

    @Column(name = "is_domestic_and_no_gk")
    private boolean isDomesticAndNotGoalkeeper;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    private Team team;

}
