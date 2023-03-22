package com.alpdogan.FootballTeamsTestCaseForPiA.repository;

import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player, Integer> {

    Player findById(int id);

}
