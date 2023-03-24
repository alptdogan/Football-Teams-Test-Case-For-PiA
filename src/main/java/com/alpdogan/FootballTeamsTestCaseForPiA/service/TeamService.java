package com.alpdogan.FootballTeamsTestCaseForPiA.service;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SaveTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;

    //just trying out limiting players etc.
    public String saveTeam(SaveTeamRequestDto saveTeamRequestDto) {

        Team team = modelMapper.map(saveTeamRequestDto, Team.class);

        //team.getPlayers().stream().limit(18);

        if (team.getPlayers().size() >= 19) {

            return team.getTeamName() + " Has Already 18 Players, Cannot Add More.";

        } else {

            team = teamRepository.save(team);

            return team.getTeamName() + " Has Been Created Successfully.";

        }

    }



}
