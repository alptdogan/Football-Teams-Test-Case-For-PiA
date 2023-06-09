package com.alpdogan.FootballTeamsTestCaseForPiA.controller;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SaveTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.UpdateTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.TeamResponseDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import com.alpdogan.FootballTeamsTestCaseForPiA.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/findTeamById")
    public ResponseEntity<Team> findTeamById (@RequestParam int teamId) {

        Team team = teamService.findTeamById(teamId);

        return new ResponseEntity<>(team, HttpStatus.OK);

    }

    @GetMapping("findAllTeams")
    public ResponseEntity<List<TeamResponseDto>> findAllTeams() {

        List<TeamResponseDto> teamResponseDtos = teamService.findAllTeams();

        return new ResponseEntity<>(teamResponseDtos, HttpStatus.OK);

    }

    @PostMapping("/saveTeam")
    public ResponseEntity<String> saveTeam (@RequestBody SaveTeamRequestDto saveTeamRequestDto) {

        String teamSaveDescription = teamService.saveTeam(saveTeamRequestDto);

        return new ResponseEntity<>(teamSaveDescription, HttpStatus.OK);

    }

    @PostMapping("/updateTeam")
    public ResponseEntity<String> updateTeamById (@RequestBody UpdateTeamRequestDto updateTeamRequestDto) {

        String updateTeamDescription = teamService.updateTeam(updateTeamRequestDto);

        return new ResponseEntity<>(updateTeamDescription, HttpStatus.OK);

    }

    @DeleteMapping("/deleteTeam")
    public ResponseEntity<String> deleteTeamById(@RequestParam Integer teamId) {

        String deleteTeamDescription = teamService.deleteTeamById(teamId);

        return new ResponseEntity<>(deleteTeamDescription, HttpStatus.OK);

    }

}
