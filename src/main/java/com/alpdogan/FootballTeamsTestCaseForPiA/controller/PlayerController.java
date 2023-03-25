package com.alpdogan.FootballTeamsTestCaseForPiA.controller;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SavePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.UpdatePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.PlayerResponseDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import com.alpdogan.FootballTeamsTestCaseForPiA.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/findPlayerById")
    public ResponseEntity<Player> findPlayerById(@RequestParam Integer playerId) {

        Player player = playerService.findPlayerById(playerId);

        return new ResponseEntity<>(player, HttpStatus.OK);

    }

    @GetMapping("/findAllPlayers")
    public ResponseEntity<List<PlayerResponseDto>> findAllPlayers() {

        List<PlayerResponseDto> playerResponseDtos = playerService.findAllPlayers();

        return new ResponseEntity<>(playerResponseDtos, HttpStatus.OK);

    }

    @PostMapping("/savePlayer")
    public ResponseEntity<String> savePlayer(@RequestBody SavePlayerRequestDto savePlayerRequestDto) {

        String playerSaveDescription = playerService.savePlayer(savePlayerRequestDto);

        return new ResponseEntity<>(playerSaveDescription, HttpStatus.OK);

    }

    @PostMapping("/updatePlayer")
    public ResponseEntity<String> updatePlayerById(@RequestBody UpdatePlayerRequestDto updatePlayerRequestDto) {

        String updatePlayerDescription = playerService.updatePlayer(updatePlayerRequestDto);

        return new ResponseEntity<>(updatePlayerDescription, HttpStatus.OK);

    }

    @DeleteMapping("/deletePlayer")
    public ResponseEntity<String> deletePlayerById(@RequestParam Integer playerId) {

        String deletePlayerDescription = playerService.deletePlayerById(playerId);

        return new ResponseEntity<>(deletePlayerDescription, HttpStatus.OK);

    }

}
