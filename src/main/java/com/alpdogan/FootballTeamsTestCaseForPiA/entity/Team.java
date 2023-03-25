package com.alpdogan.FootballTeamsTestCaseForPiA.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "foreigners")
    private int[] foreigners;

    @Column(name = "goalkeepers")
    private int[] goalkeepers;

    /*
    @Column(name = "foreigners")
    private boolean[] foreigners = new boolean[6];

    @Column(name = "goalkeepers")
    private boolean[] goalkeepers = new boolean[2];
     */

    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    private List<Player> players = new ArrayList<>(18);

}
