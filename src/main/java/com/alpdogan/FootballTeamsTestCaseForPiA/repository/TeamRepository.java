package com.alpdogan.FootballTeamsTestCaseForPiA.repository;

import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

}
