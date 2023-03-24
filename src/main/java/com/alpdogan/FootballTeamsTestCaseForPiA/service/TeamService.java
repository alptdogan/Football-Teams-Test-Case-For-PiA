package com.alpdogan.FootballTeamsTestCaseForPiA.service;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SavePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SaveTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.UpdateTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.TeamResponseDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.PlayerRepository;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PlayerRepository playerRepository;

    //just trying out limiting players etc.
    public String saveTeam(SaveTeamRequestDto saveTeamRequestDto) {

        Team team = modelMapper.map(saveTeamRequestDto, Team.class);

        team = teamRepository.save(team);

        return team.getTeamName() + " Has Been Created Successfully.";

    }

    public Team findTeamById(Integer teamId) {

        return teamRepository.findById(teamId).get();

    }

    public List<TeamResponseDto> findAllTeams() {

        Iterable<Team> teams = teamRepository.findAll();

        List<TeamResponseDto> teamResponseDtos = new ArrayList<>();

        for (Team team : teams) {
            TeamResponseDto teamResponseDto = modelMapper.map(team, TeamResponseDto.class);
            teamResponseDtos.add(teamResponseDto);
        }

        return teamResponseDtos;

    }


    /*
    public String addPlayerToTheTeam(Team team, Player player) {

        int teamId = team.getId();

        Optional<Team> teamOptional = teamRepository.findById(teamId);
        Team team1 = teamOptional.get();

        if (team1.getPlayers().size() == 18) {

            return team1.getTeamName() + " Has Already 18 Players, Cannot Add More.";

        } else if (player.isGoalkeeper() == true && team1.getGoalkeepers().length == 2) {

            return team1.getTeamName() + " Has Already 2 Goalkeepers, Cannot Add More.";

        } else if (player.isForeigner() == true && team1.getForeigners().length == 6) {

            return team1.getTeamName() + " Has Already 6 Foreign Players, Cannot Add More.";

        } else {

            team = teamRepository.save(team1);

            return "Changes Has Been Saved Successfully.";

        }

    }
     */



}
