package com.alpdogan.FootballTeamsTestCaseForPiA.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Goalkeeper extends Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    private Team team;

}
