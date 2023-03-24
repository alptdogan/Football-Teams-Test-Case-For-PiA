package com.alpdogan.FootballTeamsTestCaseForPiA.repository;

import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    //Player findById(int id);

}
