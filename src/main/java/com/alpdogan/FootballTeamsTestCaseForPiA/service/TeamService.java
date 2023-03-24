package com.alpdogan.FootballTeamsTestCaseForPiA.service;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SaveTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.UpdateTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.TeamResponseDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;

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

    public String updateTeam(UpdateTeamRequestDto updateTeamRequestDto) {

        int idTeamRequest = updateTeamRequestDto.getId();
        String nameTeamRequest = updateTeamRequestDto.getTeamName();

        Optional<Team> teamOptional = teamRepository.findById(idTeamRequest);
        Team team = teamOptional.get();

        team.setTeamName(nameTeamRequest);

        teamRepository.save(team);

        return "Changes Saved Successfully.";

    }

    public String deleteTeamById(Integer teamId) {

        Optional<Team> teamOptional = teamRepository.findById(teamId);
        Team team = teamOptional.get();

        teamRepository.delete(team);

        return "Team Deleted.";

    }

}
