package com.alpdogan.FootballTeamsTestCaseForPiA.service;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SavePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.UpdatePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.PlayerResponseDto;
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
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;

    public String savePlayer(SavePlayerRequestDto savePlayerRequestDto) {

        String fullNameRequest = savePlayerRequestDto.getFullName();
        int teamIdRequest = savePlayerRequestDto.getTeamId();

        Team team = teamRepository.findById(teamIdRequest).get();

        Player player = new Player();

        player.setFullName(fullNameRequest);
        player.setForeigner(player.isForeigner());
        player.setGoalkeeper(player.isGoalkeeper());
        player.setTeam(team);

        if (team.getPlayers().size() == 18) {

            return team.getTeamName() + " Has Already 18 Players, Cannot Add More.";

        } else if (player.isForeigner() == true && team.getForeigners().length == 6) {

            return team.getTeamName() + " Has Already 6 Foreign Players, Cannot Add More.";

        } else if (player.isGoalkeeper() == true && team.getGoalkeepers().length == 2) {

            return team.getTeamName() + " Has Already 2 Goalkeepers, Cannot Add More.";

        } else {

            List<Player> playerList = new ArrayList<>();
            playerList.add(player);

            team.setPlayers(playerList);

            playerRepository.save(player);

            return player.getFullName() + " Has Been Successfully Created.";

        }

    }

    //Bu lazım mı en son karar ver
    public Player findPlayerById(Integer playerId) {

        return playerRepository.findById(playerId).get();

    }

    public List<PlayerResponseDto> findAllPlayers() {

        Iterable<Player> players = playerRepository.findAll();

        List<PlayerResponseDto> playerResponseDtos = new ArrayList<>();

        for (Player player : players) {

            PlayerResponseDto playerResponseDto = modelMapper.map(player, PlayerResponseDto.class);

            playerResponseDtos.add(playerResponseDto);

        }

        return playerResponseDtos;

    }

    public String updatePlayer(UpdatePlayerRequestDto updatePlayerRequestDto) {

        int idPlayerRequest = updatePlayerRequestDto.getId();
        String fullNameRequest = updatePlayerRequestDto.getFullName();
        int teamIdRequest = updatePlayerRequestDto.getTeamId();

        Team team = teamRepository.findById(teamIdRequest).get();

        Optional<Player> playerOptional = playerRepository.findById(idPlayerRequest);
        Player player = playerOptional.get();

        player.setFullName(fullNameRequest);
        player.setForeigner(player.isForeigner());
        player.setGoalkeeper(player.isGoalkeeper());
        player.setTeam(team);

        if (team.getPlayers().size() == 18) {

            return team.getTeamName() + " Has Already 18 Players, Cannot Add More.";

        } else if (player.isForeigner() == true && team.getForeigners().length == 6) {

            return team.getTeamName() + " Has Already 6 Foreign Players, Cannot Add More.";

        } else if (player.isGoalkeeper() == true && team.getGoalkeepers().length == 2) {

            return team.getTeamName() + " Has Already 2 Goalkeepers, Cannot Add More.";

        } else {

            playerRepository.save(player);
            return "Changes Saved Successfully.";

        }

    }

    public String deletePlayerById(Integer playerId)
    {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        Player player = optionalPlayer.get();

        playerRepository.delete(player);

        return "Player Deleted.";

    }


}














