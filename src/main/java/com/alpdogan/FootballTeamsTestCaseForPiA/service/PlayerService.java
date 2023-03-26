package com.alpdogan.FootballTeamsTestCaseForPiA.service;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SavePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.UpdatePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.PlayerResponseDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.*;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.PlayerRepository;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.TeamRepository;
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
        boolean isGoalkeeperRequest = savePlayerRequestDto.isGoalkeeper();
        boolean isForeignerRequest = savePlayerRequestDto.isForeigner();
        int teamIdRequest = savePlayerRequestDto.getTeamId();

        Team team = teamRepository.findById(teamIdRequest).get();

        Player player = new Player();

        player.setFullName(fullNameRequest);
        player.setGoalkeeper(isGoalkeeperRequest);
        player.setForeigner(isForeignerRequest);
        player.setTeam(team);

        if (player.isGoalkeeper() && player.isGoalkeeper() && player.getTeam().getGoalkeepers().size() < 2) {

            Goalkeeper goalkeeper = new Goalkeeper();
            // burada yeni kaleci olarak oluşturduğum için kendi tablosuna yeni bir id ile kaydoluyor. isim vs tutmak istersen bu method'ta eklenebilir.

            goalkeeper.setTeam(team);

            //player.getTeam().setGoalkeepers(player.getTeam().getGoalkeepers());
            player.getTeam().getGoalkeepers().add(goalkeeper.getId(), goalkeeper);

        } else if (player.isGoalkeeper() && player.getTeam().getGoalkeepers().size() == 2) {

            return team.getTeamName() + " Has Already 2 Goalkeepers, Cannot Add More.";

        }

        if (player.isForeigner() && player.isForeigner() && player.getTeam().getForeignPlayers().size() < 6) {

            ForeignPlayer foreignPlayer = new ForeignPlayer();

            foreignPlayer.setTeam(team);

            //player.getTeam().setForeignPlayers(player.getTeam().getForeignPlayers());
            player.getTeam().getForeignPlayers().add(foreignPlayer.getId(), foreignPlayer);

        } else if (player.isForeigner() && player.getTeam().getForeignPlayers().size() == 6) {

            return team.getTeamName() + " Has Already 6 Foreign Players, Cannot Add More.";

        }

        if (player.getTeam().getPlayers().size() == 18) {

            return team.getTeamName() + " Has Already 18 Players, Cannot Add More.";

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
        boolean isGoalkeeperRequest = updatePlayerRequestDto.isGoalkeeper();
        boolean isForeignerRequest = updatePlayerRequestDto.isForeigner();
        int teamIdRequest = updatePlayerRequestDto.getTeamId();

        Team team = teamRepository.findById(teamIdRequest).get();

        Optional<Player> playerOptional = playerRepository.findById(idPlayerRequest);
        Player player = playerOptional.get();

        player.setFullName(fullNameRequest);
        player.setGoalkeeper(isGoalkeeperRequest);
        player.setForeigner(isForeignerRequest);
        player.setTeam(team);

        if (player.isGoalkeeper()) {
            player.getTeam().setGoalkeepers(player.getTeam().getGoalkeepers());
        }

        if (player.isForeigner()) {
            player.getTeam().setForeignPlayers(player.getTeam().getForeignPlayers());
        }

        if (team.getPlayers().size() == 18) {

            return team.getTeamName() + " Has Already 18 Players, Cannot Add More.";

        } else if (player.isGoalkeeper() == true && player.getTeam().getGoalkeepers().size() == 2) {

            return team.getTeamName() + " Has Already 2 Goalkeepers, Cannot Add More.";

        } else if (player.isForeigner() == true && player.getTeam().getForeignPlayers().size() == 6) {

            return team.getTeamName() + " Has Already 6 Foreign Players, Cannot Add More.";

        } else {

            playerRepository.save(player);
            return "Changes Saved Successfully.";

        }

    }

    public String deletePlayerById(Integer playerId) {

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        Player player = optionalPlayer.get();

        playerRepository.delete(player);

        return "Player Deleted.";

    }


}














