package com.alpdogan.FootballTeamsTestCaseForPiA.repository;

import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository <Team, Integer> {

    Team findById(int id);

}
