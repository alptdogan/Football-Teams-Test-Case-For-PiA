package com.alpdogan.FootballTeamsTestCaseForPiA.service;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SavePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.PlayerRepository;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.TeamRepository;
import org.hibernate.type.TrueFalseType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;

    public String savePlayer(SavePlayerRequestDto savePlayerRequestDto)
    {
        String fullNameRequest = savePlayerRequestDto.getFullName();
        //boolean isForeignerRequest = savePlayerRequestDto.setForeigner();
        //boolean isGoalkeeperRequest = savePlayerRequestDto.setGoalkeeper();
        int teamIdRequest = savePlayerRequestDto.getTeamId();

        Team team = teamRepository.findById(teamIdRequest).get();

        Player player = new Player();

        player.setFullName(fullNameRequest);
        player.setForeigner(player.isForeigner());
        player.setGoalkeeper(player.isGoalkeeper());
        player.setTeam(team);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);

        team.setPlayers(playerList);

        playerRepository.save(player);

        return player.getFullName() + " Has Been Successfully Created.";
    }


}














