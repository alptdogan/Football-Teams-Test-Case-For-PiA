package com.alpdogan.FootballTeamsTestCaseForPiA.controller;

import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import com.alpdogan.FootballTeamsTestCaseForPiA.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/findTeamById")
    public ResponseEntity<Team> findTeamById (@RequestParam Integer teamId) {

        Team team = teamService.findTeamById(teamId);

        return new ResponseEntity<>(team, HttpStatus.OK);

    }

}
